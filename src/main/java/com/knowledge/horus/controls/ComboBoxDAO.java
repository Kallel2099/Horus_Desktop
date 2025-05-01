package com.knowledge.horus.controls;

import com.knowledge.horus.models.ComboBox;
import java.util.List;

public class ComboBoxDAO extends GenericDAO<ComboBox> {

    public ComboBoxDAO() {
        super(ComboBox.class);
    }
    
    public List<ComboBox> findItem(String Combo) {
        String jpql = "from ComboBox c where c.uso like ?1";
        return find(jpql, Combo);
    }
}
