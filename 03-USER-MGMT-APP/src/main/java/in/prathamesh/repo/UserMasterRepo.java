package in.prathamesh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.prathamesh.entity.UserMaster;

public interface UserMasterRepo extends JpaRepository<UserMaster, Integer> {

	public UserMaster findEmailAndPassword(String email, String pwd);

	public UserMaster findByEmail(String email);
	
	

	

}
