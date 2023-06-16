package esprit.tn.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import esprit.tn.entity.Device;




@Repository
public interface DeviceRepository  extends JpaRepository<Device, Long>  {
	
	  List<Device> findByname(String name);
	  List<Device> findByadresse(String type);


}
