package com.example.proyekpam;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    @FormUrlEncoded
    @POST("/login")
    Call<UserOutput> getUser(
    );

    @FormUrlEncoded
    @POST("/ProyekPAM/daftar")
    Call<ResponseBody> daftar(
            @Field("id_consumer") String idS,
            @Field("username") String namaS,
            @Field("password") String passwordS,
            @Field("alamat") String roleS,
            @Field("email") String emailS
    );


//    @FormUrlEncoded
//    @POST("/ProyekPAM/tambahKelas")
//    Call<ResponseBody> (
//            @Field("id_kelas") String id_kelas,
//            @Field("pengajar") String pengajar
//    );

    




}
