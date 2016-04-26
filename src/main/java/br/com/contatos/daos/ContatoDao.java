package br.com.contatos.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.contatos.models.Contato;
import br.com.contatos.models.PaginatedList;

@Repository
public class ContatoDao {

    @PersistenceContext
    private EntityManager manager;

    public List<Contato> all() {
	return manager.createQuery("select p from Contato p", Contato.class)
		.getResultList();
    }

    public void save(Contato contato) {
	manager.persist(contato);
    }

    public Contato findById(Integer id) {
	return manager.find(Contato.class, id);
    }

    public void remove(Contato contato) {
	manager.remove(contato);
    }

    public void update(Contato contato) {
	manager.merge(contato);
    }

    public PaginatedList paginated(int page, int max) {
	return new PaginatorQueryHelper().list(manager, Contato.class, page,
		max);
    }

}
