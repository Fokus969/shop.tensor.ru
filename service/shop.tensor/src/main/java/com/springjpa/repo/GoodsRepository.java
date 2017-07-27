package com.springjpa.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.springjpa.model.Goods;

public interface GoodsRepository extends CrudRepository<Goods, Long> {
	List<Goods> findByName(String name);

}
