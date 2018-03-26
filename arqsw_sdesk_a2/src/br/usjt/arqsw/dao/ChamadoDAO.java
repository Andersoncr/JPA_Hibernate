package br.usjt.arqsw.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
/**
 * 
 * @author Anderson
 *
 */
@Repository
public class ChamadoDAO {
	@PersistenceContext
	EntityManager manager;
	
	@Autowired
	public ChamadoDAO(EntityManager manager) throws IOException{
		this.manager = manager;
	}
	
	/**
	 * @param fila Pega dados do banco
	 * @return Carrega a lista de chamados
	 */	
	@SuppressWarnings("unchecked")
	public List<Chamado> listarChamados(Fila fila) throws IOException{
		String query = "select c.id_chamado, c.descricao, c.dt_abertura, f.nm_fila, "+
				"c.dt_fechamento, c.status "+ 
				"from chamado c, fila f where c.id_fila = f.id_fila and c.id_fila=?";
		return manager.createQuery(query).getResultList();	
	}
}
