/**
 * 
 */
package org.herb.SimpleJPA.persistence;

import org.herb.SimpleJPA.domain.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author herb
 *
 */
public interface TeamRepository extends CrudRepository<Team, Long> {

}
