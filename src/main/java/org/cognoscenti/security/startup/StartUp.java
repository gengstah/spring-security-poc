package org.cognoscenti.security.startup;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.cognoscenti.security.domain.Authority;
import org.cognoscenti.security.domain.Group;
import org.cognoscenti.security.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class StartUp implements ApplicationContextAware {
	@Override
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		EntityManagerFactory emf = ctx.getBean("emf", EntityManagerFactory.class);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		if(em.find(User.class, "admin") == null) {
			em.persist(ctx.getBean("adminGroup", Group.class));
			em.persist(ctx.getBean("adminAccount", User.class));
			em.persist(ctx.getBean("adminAuthority", Authority.class));
		}
		
		if(em.find(User.class, "user") == null) {
			em.persist(ctx.getBean("userGroup", Group.class));
			em.persist(ctx.getBean("userAccount", User.class));
			em.persist(ctx.getBean("userAuthority", Authority.class));
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}