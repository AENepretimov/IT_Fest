package com.example.mkmediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mkmediaplayer.model.Video;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Video> videoList;
    public static final String MSG_NAME = "msg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        listView = findViewById(R.id.lv_video);
        videoList = new ArrayList<>();

        //НЕОБХОДИМО ЗАМЕНИТЬ URL адреса на актуальные
        videoList.add(new Video(
                        1,
                        "Вводный",
                        "Мобильная разработка?",
                "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4"
                        //"https://r1---sn-xguxaxjvh-a23e.googlevideo.com/videoplayback?expire=1607874387&ei=8-LVX8GbFoaxyQXcsIEY&ip=31.131.213.215&id=o-AMoEMSLE2WyHbMjkf8m8aZlKP5xQcDUJ5QqQY4IVbecV&itag=22&source=youtube&requiressl=yes&mh=5V&mm=31%2C29&mn=sn-xguxaxjvh-a23e%2Csn-n8v7kn7r&ms=au%2Crdu&mv=m&mvi=1&pl=22&initcwndbps=1650000&vprv=1&mime=video%2Fmp4&ns=d9lxY4DprHeIEcw0SGjVTRMF&ratebypass=yes&dur=386.031&lmt=1603371439595984&mt=1607852209&fvip=10&c=WEB&txp=6216222&n=vcrhRNWgZZ4pnJY3c&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIhAMspbGWIqCrn30pWsZOkHAfRcOzCbMfrP9KeNFHHF2XjAiBMvHokBrRyZM5HY-NXu2eS1ByYf0ycWFdk2dfbWgZlKg%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIhAJlfHhOi5oMEL2KGng8JuYJg3vJt4PAzVjKceG1rTI9jAiBrtd4tAESAa5hVggUBpz6w9zY6Z5LhEbMbh-zasvwfbQ%3D%3D"
                )
        );
        videoList.add(new Video(
                        2,
                        "Вводный",
                        "Установка ПО",
                        "https://r1---sn-4g5e6nsd.googlevideo.com/videoplayback?expire=1607869044&ei=FM7VX7DFLMWipATduqywAg&ip=31.131.213.215&id=o-AMT9zzlYZZew2FahEYdZF0UJ1A3uWqBHxpHwZE0HXx1Q&itag=22&source=youtube&requiressl=yes&vprv=1&mime=video%2Fmp4&ns=_yIx1b2WYukpS3Ryf3ZcgYsF&ratebypass=yes&dur=1472.934&lmt=1603372817415547&fvip=10&c=WEB&txp=6216222&n=3xNwA_J8mOfbmRPF2&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRgIhAMN2XBNodZqskBPyGmcLgRWL-cWLVN1fQgJUYxa-7jMWAiEA-qnJZEkepwkT6rwup3JOx1uD4XZoLItLlAd6O4HXLRU%3D&cm2rm=sn-xguxaxjvh-a23e7e,sn-n8vyee7&req_id=780bebd3c1ada3ee&redirect_counter=2&cms_redirect=yes&mh=-r&mm=34&mn=sn-4g5e6nsd&ms=ltu&mt=1607846634&mv=u&mvi=1&pl=22&lsparams=mh,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRgIhAOuTTNLlMmyAG4lUTpVavPT7Rbk2A8WUhdg2PSwP0dcSAiEAicSQjq0xzqIMGs4gXoePA2lA6XEwLlObcuwBZKOjQo8%3D"
                )
        );
        videoList.add(new Video(
                        3,
                        "Вводный",
                        "Установка Android Studio. Подробно",
                        "https://r1---sn-4g5e6ns6.googlevideo.com/videoplayback?expire=1607869129&ei=ac7VX9XlE4npyQXG0KGgDg&ip=31.131.213.215&id=o-AMWJTTUU5p1QFWvcvU7qceHrarcDRgmIcUp6CtMeIGOG&itag=22&source=youtube&requiressl=yes&vprv=1&mime=video%2Fmp4&ns=8TRIS1RxMV88MYHTbE_s17gF&ratebypass=yes&dur=537.425&lmt=1603374235291715&fvip=6&c=WEB&txp=6216222&n=UGQpWhlyf_WnUw8DT&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIhAIi2tcnq4k6Cpotb4T0ikdH942Urdf3y-fAbVEUxSPYqAiBLYQNFzBEyLxm8u9BWFXqYIlDYTTsr6VMoGw-YkqdAiA%3D%3D&cm2rm=sn-xguxaxjvh-a23e7e,sn-n8vke7d&req_id=3f2d7e3744f4a3ee&redirect_counter=2&cms_redirect=yes&mh=_S&mm=34&mn=sn-4g5e6ns6&ms=ltu&mt=1607847418&mv=u&mvi=1&pl=22&lsparams=mh,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRAIgGX_vBzOaFeNnL8klN8tbPP8ALumMp4KKOcJ0DMpJIvYCIApESLYnSN-1dRz4BoRCohVcLOTRkbxBQPTAjs9Rsrzq"
                )
        );
        videoList.add(new Video(
                        4,
                        "Вводный",
                        "Настройка эмулятора",
                        "https://r3---sn-4g5e6nzz.googlevideo.com/videoplayback?expire=1607869214&ei=vs7VX4bBKoeOyQX6vZgY&ip=31.131.213.215&id=o-AOpFp6k4Q1Jh7brmIOR71vjKLtzxZmEKLlBUkrUSUDI9&itag=22&source=youtube&requiressl=yes&vprv=1&mime=video%2Fmp4&ns=_0OgpOxTCIlL2_oZq8gZY-oF&ratebypass=yes&dur=163.793&lmt=1607289468335004&fvip=3&c=WEB&txp=6216222&n=TfyeWuGOOu4RJKSen&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIhALWcJvmGoVskmye0GGVMIJ4RJzHiJSezEbFfEiaQj_ikAiAOiU86T35loifhkeaFDV2yJJ1adEWanh5tX03ir2LbTg%3D%3D&cm2rm=sn-xguxaxjvh-a23e7s,sn-n8vre7s&req_id=2a02f6444a4ea3ee&redirect_counter=2&cms_redirect=yes&mh=jl&mm=34&mn=sn-4g5e6nzz&ms=ltu&mt=1607847418&mv=u&mvi=3&pl=22&lsparams=mh,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRAIgGs_EwYul5N5zHA9G5Q0bTQXkyRp_xj9LvnlZaTkUdTkCIG0kzz5GeuBj0cnW6ZsGYDmsNhkVg272BvuX6K2cwP0k"
                )
        );
        videoList.add(new Video(
                        5,
                        "Базовый",
                        "Язык XML. XML-разметка",
                        "https://r1---sn-4g5e6nzz.googlevideo.com/videoplayback?expire=1607869276&ei=_M7VX_jLA4rEyQW96KLIBw&ip=31.131.213.215&id=o-ALPz-zHsJP19GRtewzHDMX8L49lc2gQ3XerKMiNnEzUY&itag=22&source=youtube&requiressl=yes&vprv=1&mime=video%2Fmp4&ns=hGF3MaKfnqbLwYFYRGhh8kUF&ratebypass=yes&dur=1176.067&lmt=1603372568816672&fvip=1&c=WEB&txp=6216222&n=cW_8O26QOuPuS1G-0&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIhAKhkGNrHegC_6OvD5OToKFyNUlI2UB29YBc1B5AcbyT4AiAM-aPULy3cWo8yN1eoubobAwgRQOtZStnoBhUlIzc0tg%3D%3D&cm2rm=sn-xguxaxjvh-a23e7e,sn-n8vr67e&req_id=eb9f9b7b0fe2a3ee&redirect_counter=2&cms_redirect=yes&mh=2L&mm=34&mn=sn-4g5e6nzz&ms=ltu&mt=1607847630&mv=m&mvi=1&pl=22&lsparams=mh,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRgIhAImzvQ977zXPnOpuLrrQFyUKVAscdqXHch_gRJvj4MBcAiEA-g88p5eFGszmMYjQJsFFtToOqdj8z9zxOa50oUtfbrw%3D"
                )
        );
        videoList.add(new Video(
                        6,
                        "Базовый",
                        "базовый Визуальные компоненты",
                        "https://r2---sn-xguxaxjvh-a23e.googlevideo.com/videoplayback?expire=1607869460&ei=tM_VX4_bM5nGyAWu3o_YCQ&ip=31.131.213.215&id=o-AO9VZURrX-X5KuOGh96y3r-CdtGwGP6y0vsV1TfDudJ1&itag=22&source=youtube&requiressl=yes&mh=1v&mm=31%2C29&mn=sn-xguxaxjvh-a23e%2Csn-n8v7znzl&ms=au%2Crdu&mv=m&mvi=2&pl=22&initcwndbps=1647500&vprv=1&mime=video%2Fmp4&ns=0ms16PAm41AZ8qa_62PB3dMF&ratebypass=yes&dur=1402.601&lmt=1603372944380023&mt=1607847644&fvip=10&c=WEB&txp=6216222&n=dqp2qwene-n0t1GvI&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRAIgDCDkeuG7Fq4e0rwL3kqRVOA6hKKBFjUH7ixie5gXuAsCIGhC66l9S1SX5pkYUb5_yzICZZ3PAEej2mA5X-IF7cLq&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRAIgBuyHmo0dnjtFFFnDH3DWGvrJu3JUm_MU4xE1O6e_Pz0CIE-FraSZCmXJiOg3fI1_3TCOJLVSBrnl2wTg9oBs2XhL"
                )
        );
        videoList.add(new Video(
                        7,
                        "Базовый",
                        "Жизненный цикл Activity",
                        "https://r5---sn-4g5e6nsd.googlevideo.com/videoplayback?expire=1607869415&ei=h8_VX6jWJJS8yQXb9I34Dg&ip=31.131.213.215&id=o-AJLz_mxuukv_JGrQpGoBYy4FObXZ_KNHkoYKV5HTwxsi&itag=22&source=youtube&requiressl=yes&vprv=1&mime=video%2Fmp4&ns=J1Wkx7BqXpTg35mMOdfRy1gF&ratebypass=yes&dur=952.575&lmt=1603372846000030&fvip=16&c=WEB&txp=6216222&n=wqvpwP8AVVVJxheoJ&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRAIgN8qDleMkh8fWYwrQEZ_fsmjKOpbqQD-J-apEc1hdum4CIEOY_ZK6ytNnaYgwj0mPcEtD811hu7bAsxlCMH2Z5AoE&cm2rm=sn-xguxaxjvh-a23e7s,sn-n8vr6ed&req_id=22b1984a30b6a3ee&redirect_counter=2&cms_redirect=yes&mh=vF&mm=34&mn=sn-4g5e6nsd&ms=ltu&mt=1607847630&mv=m&mvi=5&pl=22&lsparams=mh,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRQIhAPKUk-AYOb08vezHhM5Q-5hwxaB-JAxe_99dCYS23JmpAiBcbLurWwAUcFL9fm1HaAiGDIyKxV5XbPmRBHatxUMsUA%3D%3D"
                )
        );
        videoList.add(new Video(
                        8,
                        "Базовый",
                        "Основы MVC часть 1",
                        "https://r1---sn-4g5e6nsk.googlevideo.com/videoplayback?expire=1607869684&ei=lNDVX6vTJ9aSyQWK15DwAQ&ip=31.131.213.215&id=o-AAWIoIxDxQxU2kKPv-zRvlHn7H5XSh3w6xlqNe8kN7ZH&itag=22&source=youtube&requiressl=yes&vprv=1&mime=video%2Fmp4&ns=Gw-25TyLJWjOKOdkrtaJclAF&ratebypass=yes&dur=759.942&lmt=1603372221475388&fvip=10&c=WEB&txp=6216222&n=MxFehtGhi-73_1PAa&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRAIgFsGCTlKRUzsIOlkG3MbBUQ3GfeckyM71Y1PtN5Qr4vICICQlmmUpEsFe6znwtZ_wkNxuI_iraHYrlQWFoFNW-Y4z&cm2rm=sn-xguxaxjvh-a23e7e,sn-n8vrre7&req_id=14379cf14194a3ee&redirect_counter=2&cms_redirect=yes&mh=jh&mm=34&mn=sn-4g5e6nsk&ms=ltu&mt=1607847873&mv=m&mvi=1&pl=22&lsparams=mh,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRQIgNcR17-Jn0cTpNHRoh43OfX8ndZFa24Zbenc0nLxD2egCIQD8GBeunEtV6p9D_3PGkbgO5FEBYXXDhj-Z6aCZDpgDAw%3D%3D"
                )
        );
        videoList.add(new Video(
                        9,
                        "Базовый",
                        "Основы MVC часть 2",
                        "https://r3---sn-xguxaxjvh-a23e.googlevideo.com/videoplayback?expire=1607869824&ei=INHVX66OIMaiyAWkm43gBw&ip=31.131.213.215&id=o-AKfaujxOMhyJW_6IQ9btIrETIzuZQJ3mmSYXwKHi6JqR&itag=22&source=youtube&requiressl=yes&mh=2K&mm=31%2C29&mn=sn-xguxaxjvh-a23e%2Csn-n8v7znsd&ms=au%2Crdu&mv=m&mvi=3&pcm2cms=yes&pl=22&initcwndbps=1645000&vprv=1&mime=video%2Fmp4&ns=ilt63zta8PMh_AB6qyv_6nIF&ratebypass=yes&dur=1165.223&lmt=1603373586590731&mt=1607847887&fvip=3&c=WEB&txp=6216222&n=4BUUczZFyyxLXad7G&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIhAPJ7P-iUBBbbpWTB1BuettfMLC0FdNXO2292auQY9kMbAiAFgwQrm6O3ComcbCbL3aB-KJufQcRTZdBsKhcVd9RfgQ%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpcm2cms%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRQIhAOXHXcxCIo1k2FUoZOZQAR6X5x9w9fWuSrxh8JNQUMARAiBKkkE3ahdRMzOlDkQ8suKVFzlCWe8Rp4b68pXDExLSdQ%3D%3D"
                )
        );
        videoList.add(new Video(
                        10,
                        "Базовый",
                        "Обработка нажатий",
                        "https://r2---sn-xguxaxjvh-a23e.googlevideo.com/videoplayback?expire=1607869870&ei=TtHVX-ifE8TeyAWjyoewDg&ip=31.131.213.215&id=o-AJpdOKJqmpQWmvkQh8NtaJp0jK9ddghTVWfRx_-yvC8L&itag=22&source=youtube&requiressl=yes&mh=xK&mm=31%2C29&mn=sn-xguxaxjvh-a23e%2Csn-n8v7sney&ms=au%2Crdu&mv=m&mvi=2&pcm2cms=yes&pl=22&initcwndbps=1645000&vprv=1&mime=video%2Fmp4&ns=hfZVhKqeirymKwphOXtZuaYF&ratebypass=yes&dur=1100.323&lmt=1603373857416041&mt=1607847887&fvip=2&c=WEB&txp=6216222&n=ohLxCpuKi2uAw98v2&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIgTTfcz1ZFXlstsriGfIdjK28C4O6Jkr0eowntWegXsrACIQDYZPLjxH5D8GHivbCsgqGW_gNh5Csp-JO6v50XYbu3IQ%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpcm2cms%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRAIgPIsVrOsetC3uMECnRXuOFhGrYq_BVtmvypI6YgJNKBACIAYleJLc08jeWPqsRe8_LVzAZr7Xxc9A8I6nSSxli3Qm"
                )
        );
        videoList.add(new Video(
                        11,
                        "Продвинутый",
                        "Создание нескольких Activity часть 1",
                        "https://r2---sn-xguxaxjvh-a23e.googlevideo.com/videoplayback?expire=1607869870&ei=TtHVX-ifE8TeyAWjyoewDg&ip=31.131.213.215&id=o-AJpdOKJqmpQWmvkQh8NtaJp0jK9ddghTVWfRx_-yvC8L&itag=22&source=youtube&requiressl=yes&mh=xK&mm=31%2C29&mn=sn-xguxaxjvh-a23e%2Csn-n8v7sney&ms=au%2Crdu&mv=m&mvi=2&pcm2cms=yes&pl=22&initcwndbps=1645000&vprv=1&mime=video%2Fmp4&ns=hfZVhKqeirymKwphOXtZuaYF&ratebypass=yes&dur=1100.323&lmt=1603373857416041&mt=1607847887&fvip=2&c=WEB&txp=6216222&n=ohLxCpuKi2uAw98v2&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIgTTfcz1ZFXlstsriGfIdjK28C4O6Jkr0eowntWegXsrACIQDYZPLjxH5D8GHivbCsgqGW_gNh5Csp-JO6v50XYbu3IQ%3D%3D&lsparams=mh%2Cmm%2Cmn%2Cms%2Cmv%2Cmvi%2Cpcm2cms%2Cpl%2Cinitcwndbps&lsig=AG3C_xAwRAIgPIsVrOsetC3uMECnRXuOFhGrYq_BVtmvypI6YgJNKBACIAYleJLc08jeWPqsRe8_LVzAZr7Xxc9A8I6nSSxli3Qm"
                )
        );
        videoList.add(new Video(
                        12,
                        "Продвинутый",
                        "Создание нескольких Activity часть 2",
                        "https://r4---sn-4g5e6nsr.googlevideo.com/videoplayback?expire=1607870098&ei=MtLVX8KHFInpyQXG0KGgDg&ip=31.131.213.215&id=o-ABZG0bUTOWoY0WUi517mg-q9MbEOxCs7oggy2NX7RmxG&itag=22&source=youtube&requiressl=yes&vprv=1&mime=video%2Fmp4&ns=WQwlXiBrzfHK8xKzEnfBfnIF&ratebypass=yes&dur=1033.450&lmt=1603377195000474&fvip=18&c=WEB&txp=6216222&n=BdUVcMayRxluKQZXK&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRAIgVLVwH1BrhSFws9-v0gLVDVXPf4yXECfNa2fqdIwwjlYCIAtNs9QEU9hNr0c2pZJ7V2NyliA5LkzpYprvHfU7y0wr&cm2rm=sn-xguxaxjvh-a23e7s,sn-n8vr7er&req_id=f91fa3b4e46a3ee&redirect_counter=2&cms_redirect=yes&mh=EO&mm=34&mn=sn-4g5e6nsr&ms=ltu&mt=1607848353&mv=m&mvi=4&pl=22&lsparams=mh,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRQIhAPL2LdbVfFAP0R6yLQJvE72kRIzQM5m5g3cXVs-XeYl3AiBYYX8YiONOl1O_fxLelhIZQ5qsW9SUps1jhWzFq2IfUA%3D%3D"
                )
        );
        videoList.add(new Video(
                        13,
                        "Итоговый",
                        "Android-игра часть 1",
                        "https://r4---sn-4g5ednld.googlevideo.com/videoplayback?expire=1607870153&ei=adLVX9eZMYvHyAX82pjYCA&ip=31.131.213.215&id=o-APME1ejkoKNLYZJ7ggiLkqdzI1nhk_nMhaK5HmDKIOi8&itag=22&source=youtube&requiressl=yes&vprv=1&mime=video%2Fmp4&ns=XMxX_l_I41xHbNH8VJSGA7MF&ratebypass=yes&dur=1218.583&lmt=1603375894432111&fvip=15&c=WEB&txp=6216222&n=UUSe01Bf2Onu9Gq1l&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRAIgB_QVtWTjcpg9CDbeAU6zhsOZ_KySrQkdJUPa_Gxma-4CIBCH_b4nRyVw3U06vzpS9-neMRa4oZjXlPzhTwjSvVMu&cm2rm=sn-xguxaxjvh-a23e7s,sn-n8vrre6&req_id=5e7eee5860d5a3ee&redirect_counter=2&cms_redirect=yes&mh=c_&mm=34&mn=sn-4g5ednld&ms=ltu&mt=1607848353&mv=m&mvi=4&pl=22&lsparams=mh,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRgIhAPl0TXYWu3hTs6ThLokq8crt4bKY2Jf7D9F1qi2Gatd6AiEA2INXyWYn8BCM87h-MgebnlkNvRptqHsPWwHEiV6vOW8%3D"
                )
        );
        videoList.add(new Video(
                        14,
                        "Итоговый",
                        "Android-игра часть 2",
                        "https://r5---sn-4g5ednsk.googlevideo.com/videoplayback?expire=1607870194&ei=ktLVX_-XLoqByQW6g59g&ip=31.131.213.215&id=o-ADXq1jSqFU-Pyq0hMPIBaKArHbjLnQAh39g-GV61uDY7&itag=22&source=youtube&requiressl=yes&vprv=1&mime=video%2Fmp4&ns=3Fny5B4iCnT2s4Nt-cTqH5sF&ratebypass=yes&dur=1216.702&lmt=1603378090322561&fvip=17&c=WEB&txp=6216222&n=HJwVHwMUHn01SIn-d&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIhAIXa96zrUww2oG2xkyn-CC1qksX3SGFSn0fUx8_xv4bLAiBoRFNOpz2YhA98wwMZ7YqZr1MLCbOGs7ijB3HJWL6tiQ%3D%3D&cm2rm=sn-xguxaxjvh-a23e7l,sn-n8vreek&req_id=b70502177549a3ee&redirect_counter=2&cms_redirect=yes&mh=fY&mm=34&mn=sn-4g5ednsk&ms=ltu&mt=1607848593&mv=m&mvi=5&pl=22&lsparams=mh,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRgIhAPN2r_dSeG-Q_NMNLpeAo2_phhkW-ie-OKAZ5PkiGKpXAiEAtTMC6pKdgFVC_IzhnXKmChNewfxID6-h82sJLJUIVPQ%3D"
                )
        );
        videoList.add(new Video(
                        15,
                        "Итоговый",
                        "Android-игра часть 3",
                        "https://r3---sn-4g5e6ns6.googlevideo.com/videoplayback?expire=1607870247&ei=x9LVX72dG8KS7ATqxJq4Dw&ip=31.131.213.215&id=o-AM7ZB6Ona4NcYMIqDFyd4Y09XHKwRi_D-i5I4IJf1eQX&itag=22&source=youtube&requiressl=yes&vprv=1&mime=video%2Fmp4&ns=YrxtjnR3URoLMo4dl91znjcF&ratebypass=yes&dur=1131.903&lmt=1603377977781998&fvip=14&c=WEB&txp=6216222&n=QN1h6_Zd0IEbFwrOO&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cvprv%2Cmime%2Cns%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIgBnSdpoG7_qKF6U3xOIHluUvbOzm20bE1QS43_ijYQEwCIQDccqiCVEwUMGL2YOuRgP4XdIUaO0SC-0kM_jzG_F1d0w%3D%3D&cm2rm=sn-xguxaxjvh-a23e7s,sn-n8vyeez&req_id=58d5579c28b5a3ee&redirect_counter=2&cms_redirect=yes&mh=z8&mm=34&mn=sn-4g5e6ns6&ms=ltu&mt=1607848593&mv=m&mvi=3&pl=22&lsparams=mh,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRQIgfcffVNifI1HJaTw5s5yTLIO74QqPx2SJLn1VIBQELUYCIQDmIHZqpXk0_nO-LVNDnlkhsvSbJ6jmvMTc5AhKmTZD_A%3D%3D"
                )
        );

        VideoAdapter videoAdapter = new VideoAdapter(this, R.layout.list_item, videoList);
        listView.setAdapter(videoAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                intent.putExtra(MSG_NAME, videoList.get(position));
                startActivity(intent);
            }
        });
    }
}