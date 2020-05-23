package jcg.zheng.demo.vaadinwebdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jcg.zheng.demo.vaadinwebdemo.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
