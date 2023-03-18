package Alparslan.Kodlama.io.Devs.entities.concretes;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "languages")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "languageId")
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany
	@JoinColumn(name = "languageId")
	private Set<FrameWork> frameWorks;

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name="id",nullable = false)
//	private FrameWork frameWork;

}