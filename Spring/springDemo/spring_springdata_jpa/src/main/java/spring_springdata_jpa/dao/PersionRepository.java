package spring_springdata_jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import spring_springdata_jpa.domain.Persion;


public interface PersionRepository extends JpaRepository<Persion,Long>,IPersionDao<Persion>{

}
