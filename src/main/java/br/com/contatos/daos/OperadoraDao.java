package br.com.contatos.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.contatos.models.Operadora;
import br.com.contatos.models.PaginatedList;

@Repository
public class OperadoraDao {

    @PersistenceContext
    private EntityManager manager;

    public List<Operadora> all() {
	return manager
		.createQuery("select c from Operadora c", Operadora.class)
		.getResultList();
    }

    public void save(Operadora operadora) {
	manager.persist(operadora);
    }

    public Operadora findById(Integer id) {
	return manager.find(Operadora.class, id);
    }

    public void remove(Operadora operadora) {
	manager.remove(operadora);
    }

    public void update(Operadora operadora) {
	manager.merge(operadora);
    }

    public PaginatedList paginated(int page, int max) {
	return new PaginatorQueryHelper().list(manager, Operadora.class, page,
		max);
    }

}
