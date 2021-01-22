package fr.maelle.filmotheque.service;

import fr.maelle.filmotheque.bean.Style;
import fr.maelle.filmotheque.dao.GenericDAOImpl;
import fr.maelle.filmotheque.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class GestionStyle {

    private static final Logger logger = LogManager.getLogger(GestionStyle.class);

    private static GenericDAOImpl<Style, Integer> genericDAOImpl = null;
    private static GestionStyle gestionStyle = null;

    public static GestionStyle getInstance() {

        if (gestionStyle == null) {

            gestionStyle = new GestionStyle();
            genericDAOImpl = new GenericDAOImpl<>();
        }

        return gestionStyle;
    }

    public void addStyle(Style style) throws DAOException {

        genericDAOImpl.add(style);
    }

    public void updateStyle(Style style) throws DAOException {

        genericDAOImpl.update(style);
    }

    public void deleteStyle(Style style) throws DAOException {

        genericDAOImpl.delete(style);
    }

    public void deleteStyle(int id) throws DAOException {

        Style style = genericDAOImpl.findById(Style.class, id);

        genericDAOImpl.delete(style);
    }

    public List<Style> findAll() throws DAOException {

        return genericDAOImpl.findAll(Style.class);
    }

    public Style findById(int id) throws DAOException {

        return genericDAOImpl.findById(Style.class, id);
    }
}
