package org.futboldata.frontend.repositories;

import org.futboldata.frontend.domain.Grupo;
import org.futboldata.frontend.domain.Jornada;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
@Transactional(readOnly = true)
public class ClasificacionCustomRepositoryImpl implements ClasificacionCustomRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Iterable<Object> listByGrupoJornada(Grupo grupo, Jornada jornada) {

        String q = "SELECT e.nombre, SUM(c.jJugados) AS jj, SUM(c.jGanados) AS jg, " +
                "SUM(c.jEmpatados) as je, SUM(c.jPerdidos) AS jp, SUM(c.golesFavor) AS gf, " +
                "SUM(c.golesContra) as gc, SUM(c.diferencia) AS dif, SUM(c.puntos) AS pts " +
                "FROM Clasificacion c JOIN c.equipo e " +
                "WHERE c.grupo = :grupo AND c.jornada <= :jornada " +
                "GROUP BY e.id " +
                "ORDER BY pts DESC, dif DESC";
        Query query = em.createQuery(q);
        query.setParameter("grupo", grupo);
        query.setParameter("jornada", jornada);
        return query.getResultList();
    }
}
