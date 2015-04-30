/**
 * 
 */
package org.herb.SimpleJPA.persistence;

import java.util.List;

import org.herb.SimpleJPA.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * @author herb
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	List<Customer> findByLastName(String lastName);

}
