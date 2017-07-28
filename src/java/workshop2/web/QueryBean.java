package workshop2.web;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import workshop2.model.Customer;

@SessionScoped
@Named
public class QueryBean implements Serializable{
    
    @PersistenceContext private EntityManager em;
    @Resource UserTransaction ut;
    
    private int queryId;
    private Customer customer = null;

    public int getQueryId() {
        return queryId;
    }

    public void setQueryId(int queryId) {
        this.queryId = queryId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public void search(){
        System.out.println("Searching for customer...");
        try {
            ut.begin();
            customer = em.find(Customer.class, queryId);
            customer.getPurchaseOrders().size();
            ut.commit();
        } catch (NotSupportedException ex) {
            Logger.getLogger(QueryBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(QueryBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RollbackException ex) {
            Logger.getLogger(QueryBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicMixedException ex) {
            Logger.getLogger(QueryBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (HeuristicRollbackException ex) {
            Logger.getLogger(QueryBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(QueryBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(QueryBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException nl) {
            FacesMessage msg = new FacesMessage("Cannot find customer " + queryId);
            FacesContext.getCurrentInstance().addMessage("queryForm:queryIdField", msg);
        }
        
        if(!(null == customer))System.out.println(">>>Customer name" + customer.getName());
        
        /*
        if(null == customer){
            FacesMessage msg = new FacesMessage("Cannot find customer " + queryId);
            FacesContext.getCurrentInstance().addMessage("queryForm:queryIdField", msg);
        }
        */

    }
    
    public void clear(){
        System.out.println("Clearing customer data...");

    }
    
}
