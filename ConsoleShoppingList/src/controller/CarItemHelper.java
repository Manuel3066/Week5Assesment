/**
 * @author theaw - mcorralledezma@dmacc.edu
 * CIS175 - Spring 2022
 * Feb 3, 2022
 */
package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CarItem;
import java.util.List;

/**
 * @author theaw
 *
 */

public class CarItemHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleShoppingList");
	
	public void insertItem(CarItem li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CarItem>showAllitems(){
		EntityManager em = emfactory.createEntityManager();
		List<CarItem>allItems = em.createQuery("SELECT i FROM CarItem i").getResultList();
		return allItems;
	}
	
	public void deleteItem(CarItem toDelete) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<CarItem>typedQuery = em.createQuery("select li from CarItem li where li.model = :selectedModel and li.color = :selectedColor",CarItem.class);
			
			typedQuery.setParameter("selectedModel", toDelete.getModel());
			typedQuery.setParameter("selectedColor", toDelete.getColor());
			
			
			typedQuery.setMaxResults(1);
			
			CarItem result = typedQuery.getSingleResult();
			
			em.remove(result);
			em.getTransaction().commit();
			em.close();
	}

	/**
	 * @param toEdit
	 */
	public void updateItem(CarItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public CarItem searchForCarById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CarItem found = em.find(CarItem.class, idToEdit);
		em.close();
		
		return found;
	}

	/**
	 * @param modelName
	 * @return
	 */
	public List<CarItem> searchforCarByModel(String modelName) {
		// TODO Auto-generated method stub
		EntityManager em=emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarItem>typedQuery= em.createQuery("select li from CarItem li where li.model = :selectedModel", CarItem.class);
		typedQuery.setParameter("selectedModel", modelName);
		List<CarItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	/**
	 * @param itemName
	 * @return
	 */
	public List<CarItem> searchForCarByColor(String colorName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarItem>typedQuery=em.createQuery("select li from CarItem li where li.color = :selectedColor", CarItem.class);
		typedQuery.setParameter("selectedColor", colorName);
		List<CarItem>foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;

	}	
	
	public void cleanUp() {
		emfactory.close();
	}
}
