package at.htl.survey.controller;

import at.htl.survey.model.Questionnaire;

import java.util.List;

public interface Persistent<T> {

    public void save(T entity);
    public void insert(T entity);
    public void delete(int id);
    public List<T> findAll();
    public T findById(int id);
}
