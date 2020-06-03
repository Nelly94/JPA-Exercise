package dao;

import model.Orc;

import java.util.List;

public interface OrcDAO extends GenericDAO<Orc, Long> {

    public List<Orc> findByRage(String rage);
}
