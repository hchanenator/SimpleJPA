/**
 * 
 */
package org.herb.SimpleJPA.persistence;

import org.herb.SimpleJPA.domain.Player;
import org.springframework.data.repository.CrudRepository;

/**
 * @author herb
 *
 */
public interface PlayerRepository extends CrudRepository<Player, Long> {

}
