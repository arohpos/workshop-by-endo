package logic;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.AbstractBean;
import beans.ConcreteBean;
import dao.AbstractDao;
import dao.ConcreteDao;

public class SampleLogic {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		AbstractDao concreteDao = new ConcreteDao();
		List<AbstractBean> abstractBeanList = concreteDao.findAll();
		
		//AbstractBeanクラスからConcreteBeanクラスへダウンキャストする
		List<ConcreteBean> concreteBeanList = new ArrayList<>();
		for(AbstractBean abstractBean : abstractBeanList) {
			if(abstractBean instanceof ConcreteBean) {
				ConcreteBean concreteBean = (ConcreteBean)abstractBean;
				concreteBeanList.add(concreteBean);
			}
		}
		request.setAttribute("concreteBeanList", concreteBeanList);
	}
}
