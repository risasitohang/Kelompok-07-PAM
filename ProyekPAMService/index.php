<?php
 
require_once 'include/DbHandler.php';
require_once 'include/PassHash.php';
require 'libs/Slim/Slim.php';

\Slim\Slim::registerAutoloader();

$app = new \Slim\Slim();

/**
 * ----------- METHODS WITHOUT AUTHENTICATION ---------------------------------
 */
 
//hasil
$app->post('/hasil', function () use($app) {
	$response = array();

	$db = new DbHandler();

	// fetching all hasil
	$result = $db->getDosen();
		//print_r($result);

	$app->contentType('application/json');	

	$response["error"] = false;
	$response["hasil"] = array();

	// looping through result and preparing materi array
	while ($strData = $result->fetch_assoc()) {
	    $tmp = array();
	    $tmp["nidn"] = utf8_encode($strData["nidn"]);
	    $tmp["nama"] = utf8_encode($strData["nama"]);
	    $tmp["pengajar"] = utf8_encode($strData["pengajar"]);
	    $tmp["password"] = utf8_encode($strData["password"]);

	    array_push($response["hasil"], $tmp);
	}

	echoRespnse(200, $response);
});

$app->post('/tambahKelas', function() use($app){

	$db = new DbHandler();

	$id_kelas = $app->request->post('id_kelas');
	$pengajar = $app->request->post('pengajar');

	$responseJson["error"] = false;


	$result = $db->addKelas($id_kelas, $pengajar);

	echo json_encode($responseJson);


});

$app->post('/daftar', function() use($app){
	$db = new DbHandler();

	$id_consumer = $app->request->post('id_consumer');
	$username = $app->request->post('username');
	$password = $app->request->post('password');
	$alamat = $app->request->post('alamat');
	$email = $app->request->post('email');

	$responseJson["error"] = false;

	$result = $db->daftar($id_consumer, $username, $password, $alamat, $email);

	echo json_encode($responseJson);
});

$app->post('/login', function () use($app) {
	$response = array();

	$db = new DbHandler();

	$id = $app->request->post('id');
	$password = $app->request->post('password');

	// fetching all hasil
	$result = $db->login($id, $password);
		//print_r($result);


	$response["error"] = false;
	$response["user"] = array();

	// looping through result and preparing materi array
	while ($strData = $result->fetch_assoc()) {
	    $tmp = array();
	    $tmp["id"] = utf8_encode($strData["id"]);
	    $tmp["nama"] = utf8_encode($strData["nama"]);
	    $tmp["password"] = utf8_encode($strData["password"]);
	    $tmp["role"] = utf8_encode($strData["role"]);
	    array_push($response["user"], $tmp);
	}

	echo json_encode($response);
});


/**
 * Echoing json response to client
 * @param String $status_code Http response code
 * @param Int $response Json response
 * Daftar response
 * 200	OK
 * 201	Created
 * 304	Not Modified
 * 400	Bad Request
 * 401	Unauthorized
 * 403	Forbidden
 * 404	Not Found
 * 422	Unprocessable Entity
 * 500	Internal Server Error
 */
function echoRespnse($status_code, $response) {
    $app = \Slim\Slim::getInstance();
    // Http response code
    $app->status($status_code);

    // setting response content type to json
    $app->contentType('application/json');

	//print_r($response);
    echo json_encode($response);
}


$app->run();
?>