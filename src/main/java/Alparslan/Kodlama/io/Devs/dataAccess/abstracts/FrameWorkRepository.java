package Alparslan.Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Alparslan.Kodlama.io.Devs.entities.concretes.FrameWork;

public interface FrameWorkRepository extends JpaRepository<FrameWork, Integer> {
	boolean existsByName(String name);
}
