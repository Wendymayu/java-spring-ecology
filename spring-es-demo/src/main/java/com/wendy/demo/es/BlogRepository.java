package com.wendy.demo.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/23 23:47
 * @Version 1.0
 */
@Repository
public interface BlogRepository extends ElasticsearchRepository<BlogDoc, Long> {

}
