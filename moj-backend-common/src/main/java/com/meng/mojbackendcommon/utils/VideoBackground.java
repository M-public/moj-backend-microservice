package com.meng.mojbackendcommon.utils;

import java.io.IOException;
/**
 * @DESCRIPTION: description
 * @AUTHOR: MENGLINGQI
 * @TIME: 2024/10/8 21:24
 **/


public class VideoBackground {
    public static void addBackground(String videoPath, String backgroundImagePath, String outputPath) {
        try {
            String command = "ffmpeg -i " + videoPath + " -i " + backgroundImagePath + " -filter_complex \"[1:v]scale=iw*min(1/,ih/ih/,ow/ow):ih*min(1/,iw/iw/,oh/oh),format=rgba,fade=in:st=0:d=1[bg];[0:v][bg]overlay=x='if(gte(w-ow/2,0),mod(N/,w+ow)/w-ow/2,N/w-ow/2)':y='if(gte(h-oh/2,0),mod(N/,h+oh)/h-oh/2,N/h-oh/2)',fade=out:st=15:d=1\" -c:v libx264 -crf 18 -pix_fmt yuv420p -c:a copy " + outputPath;
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 视频路径
        String videoPath = "D:/test/aaa.mp4";
        // 背景图片路径
        String backgroundImagePath = "D:/test/background.png";
        // 输出视频路径
        String outputPath = "D:/test/output.mp4";

        addBackground(videoPath, backgroundImagePath, outputPath);
    }
}