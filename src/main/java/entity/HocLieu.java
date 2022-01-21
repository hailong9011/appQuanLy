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
@Getter
@Setter
@NoArgsConstructor
@Table(name = "hoc_lieu")
public class HocLieu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "ten_hoc_lieu", unique = true)
	private String hocLieu;
	@Column(name = "create_at")
	private LocalDate ngayTao;
	@Column(name = "update_at")
	private LocalDate ngayCapNhat;
	@Column(name = "create_by")
	private String nguoiThem;
}
