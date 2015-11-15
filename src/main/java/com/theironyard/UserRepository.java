package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by cameronoakley on 11/15/15.
 */
public interface UserRepository extends CrudRepository<User, Integer > {
    User findOneByName(String name);
}
