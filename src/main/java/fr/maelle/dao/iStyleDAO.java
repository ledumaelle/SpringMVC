package fr.maelle.dao;

import fr.maelle.bean.Style;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iStyleDAO extends JpaRepository<Style,Integer> {
}
