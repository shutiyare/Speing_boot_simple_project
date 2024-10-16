package com.shutiye.demo.courses;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
@org.springframework.stereotype.Repository
public interface CoursesRepository  extends CrudRepository<Courses,Integer> {
}
