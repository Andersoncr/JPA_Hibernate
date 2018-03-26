package br.usjt.arqsw.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Fila;
/**
 * 
 * @author Anderson
 *
 */
@Repository
public class FilaDAO {
	@PersistenceContext
	EntityManager manager;
	
	@Autowired
	public FilaDAO(EntityManager manager) throws IOException {
		this.manager = manager;
	}

	/**
	 * 
	 * @return Pegar os dados do banco e carrega a lista das filas
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public List<Fila> listarFilas() {
		return manager.createQuery("select l from Fila l").getResultList();
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws IOException
	 */
	public Fila carregar(int id) {
		return manager.find(Fila.class, id);
	}
}
