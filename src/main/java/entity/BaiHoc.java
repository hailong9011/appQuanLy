package entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "bai_hoc")
public class BaiHoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "word")
	private String word;
	@Column(name = "slide")
	private String slide;
	@Column(name = "bai_tap")
	private String baiTap;
	@Column(name = "video")
	private String video;
	@Column(name = "ten_bai")
	private String tenBai;
	@Column(name = "create_at")
	private LocalDate ngayTao;
	@Column(name = "update_at")
	private LocalDate ngayCapNhat;
	@Column(name = "id_hoc_lieu")
	private Long idHocLieu;
}
