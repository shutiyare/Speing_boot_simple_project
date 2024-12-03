package com.shutiye.demo.courses;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository  extends CrudRepository<Courses,Integer> {
}
