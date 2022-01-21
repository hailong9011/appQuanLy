package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
	private static SessionFactory sessionFactory;
	static {
		if (sessionFactory == null) {
			StandardServiceRegistry reg = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources source = new MetadataSources(reg);
			Metadata metadata = source.getMetadataBuilder().build();
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}