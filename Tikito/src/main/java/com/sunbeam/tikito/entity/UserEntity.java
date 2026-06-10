package com.sunbeam.tikito.entity;

    import java.time.LocalDateTime;
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.PrePersist;
	import jakarta.persistence.PreUpdate;
	import jakarta.persistence.Table;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

	
	@Entity
	@Table(name = "Users")
    @NoArgsConstructor
    @AllArgsConstructor
	@Data
	//@ToString(exclude == "")
	public class UserEntity {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long userId;

	    @Column(nullable = false)
	    private String firstName;

	    @Column(nullable = false)
	    private String lastName;

	    @Column(unique = true, nullable = false)
	    private String email;

	    @Column(nullable = false)
	    private String password;

	    @Column(unique = true, nullable = false)
	    private String phone;

	    @Column(nullable = false)
	    private String role;

	    private String imageName;

	    private LocalDateTime createdAt;

	    private LocalDateTime updatedAt;
	    
	    @PrePersist
	    public void onCreate() {
	    createdAt = LocalDateTime.now();
	    updatedAt = LocalDateTime.now();
	}
	    @PreUpdate
	    public void onUpdate() {
	    updatedAt = LocalDateTime.now();
	}

	    
	}


