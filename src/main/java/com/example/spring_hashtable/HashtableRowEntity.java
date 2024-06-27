package com.example.spring_hashtable;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.*;

@Entity
@Data
public class HashtableRowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int index;

    @ManyToOne
    @JoinColumn(name = "first_cell_id")
    HashtableCellEntity firstCell;
    @OneToMany(mappedBy = "row", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<HashtableCellEntity> cells = new LinkedList<>();

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public HashtableCellEntity getFirstCell() {
        return firstCell;
    }

    public void setFirstCell(HashtableCellEntity firstCell) {
        this.firstCell = firstCell;
    }

    public List<HashtableCellEntity> getCells() {
        return cells;
    }

    public void setCells(LinkedList<HashtableCellEntity> cells) {
        this.cells = cells;
    }
}
