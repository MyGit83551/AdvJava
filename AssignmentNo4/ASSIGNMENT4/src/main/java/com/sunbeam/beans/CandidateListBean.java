/*package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojos.Candidate;
import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;




public class CandidateListBean {
	private Candidate candidate;
	
	
	public void candidateList() {
	
	List<Candidate> list = new ArrayList<Candidate>();
	try(CandidateDao candDao = new CandidateDaoImpl()){
		list = candDao.findAll();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException(e);
	}
}

}
*/

package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.pojos.Candidate;
import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class CandidateListBean {
    private List<Candidate> list;

    public List<Candidate> getList() {
        return list;
    }

    public void candidateList() {
        list = new ArrayList<Candidate>();
        try (CandidateDao candDao = new CandidateDaoImpl()) {
            list = candDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

