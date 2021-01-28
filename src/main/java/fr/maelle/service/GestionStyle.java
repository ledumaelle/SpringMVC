package fr.maelle.service;

import fr.maelle.bean.Style;
import fr.maelle.dao.iStyleDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestionStyle {

    @Autowired
    private iStyleDAO iStyleDAO;

    private static final Logger logger = LogManager.getLogger(GestionStyle.class);

    public void add(Style style){

        iStyleDAO.save(style);
    }

    public void update(Style style) {

        iStyleDAO.save(style);
    }

    public void delete(Style style){

        delete(style.getId());
    }

    public void delete(int id){

        Optional<Style> style = findById(id);

        if(style.isPresent()) {
            iStyleDAO.deleteById(style.get().getId());
        }
    }

    public List<Style> findAll() {

        return iStyleDAO.findAll();
    }

    public Optional<Style> findById(int id){

        return iStyleDAO.findById(id);
    }
}
