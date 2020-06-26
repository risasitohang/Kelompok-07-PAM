<?php

class DbHandler {
 
    private $conn;
 
    function __construct() {
        require_once dirname(__FILE__) . './DbConnect.php';
        // opening db connection
        $db = new DbConnect();
        $this->conn = $db->connect();
    }
 
	/**
	* Fetching hasil liga mingguan
	*/
	public function getUser(){
		$stmt = $this->conn->prepare("SELECT * from user ORDER BY id ASC");
		
		$stmt->execute();
		$tasks = $stmt->get_result();
        $stmt->close();
		
        return $tasks;		

	}
 
	public function login($id, $password){
		$stmt = $this->conn->prepare("SELECT * from user where id=? AND password=? ");
		
		$stmt->bind_param("ss", $id, $password);
		$stmt->execute();
		$tasks = $stmt->get_result();
        $stmt->close();
		
        return $tasks;	
	}

	public function addKelas($id_kelas, $pengajar){
		$stmt = $this->conn->prepare("INSERT INTO kelas SET idKelas =?, dosen =? ");
		$stmt->bind_param("ss",$id_kelas, $pengajar);
		$stmt->execute();
		$stmt->close();
	}

	public function daftar($id_consumer, $username, $password, $alamat, $email){
		$stmt = $this->conn->prepare("INSERT INTO consumer SET id_consumer = ?, username = ?, password = ?, alamat = ?, email = ?");
		$stmt->bind_param("sssss", $id_consumer, $username, $password, $alamat, $email);
		$stmt->execute();
		$stmt->close();
	}
}
	 
?>