package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

import constant.Page;
import dao.ProducerDao;
import dao.impl.ProducerDaoImpl;
import model.Producer;

@Results(value = { @Result(name = "producerIndex", location = Page.PRODUCER_INDEX_PAGE),
		@Result(name = "producerForm", location = Page.PRODUCER_FORM_PAGE),
})
public class ProducerAction extends ActionSupport {

	private static final long serialVersionUID = -5252328907327276691L;

	private Producer producerBean = new Producer();
	private ProducerDao producerDao = new ProducerDaoImpl() ;

	@Action("/producers")
	public String producerIndex() {
		return "producerIndex";
	}

	@Action(value = "/producer/add") 
	public String addProducer() {
		return "producerForm";
	}
	
	@Action(value = "/producer/save")
	public String saveProducer() {
		
		return "producerIndex";
	}
	
	public Producer getProducerBean() { // làm việc với producerBean bỏ  "get" trong ProducerBean
		return producerBean;
	}

	public void setProducerBean(Producer producerBean) { // setMauLol => mauLol
		this.producerBean = producerBean;
	}

}
