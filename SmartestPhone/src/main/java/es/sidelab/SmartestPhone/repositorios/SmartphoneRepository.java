package es.sidelab.SmartestPhone.repositorios;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.sidelab.SmartestPhone.clases.Smartphone;

@CacheConfig(cacheManager="smartphones", cacheNames="smartphones")
public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {

	@SuppressWarnings("unchecked")
	@CacheEvict(allEntries=true)
	Smartphone save(Smartphone smartphone);
	
	@Cacheable
	List<Smartphone> findByMarcaAndModelo(String marca, String modelo);
	@Cacheable
	Smartphone findByIdSmartphone(long idSmartphone);
	@Cacheable
	List<Smartphone> findByCamaraIdCamara(long idCamara);
	@Cacheable
	List<Smartphone> findByProcesadorIdProcesador(long idProcesador);
	@Cacheable
	List<Smartphone> findAll();

}
