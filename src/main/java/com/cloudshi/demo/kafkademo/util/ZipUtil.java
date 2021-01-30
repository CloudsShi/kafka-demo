package com.cloudshi.demo.kafkademo.util;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.*;

/**
 * ZIP工具
 */
@Slf4j
public class ZipUtil {
    /**
     * gzip压缩
     * @param str 未压缩的字符串
     * @return
     */
    public static String gzip(String str) {
        if(StrUtil.isBlank(str)) {return str;}

        try(
                ByteArrayOutputStream out=new ByteArrayOutputStream();
                GZIPOutputStream gzip=new GZIPOutputStream(new ByteArrayOutputStream())
        ) {
            gzip.write(str.getBytes());
            return new BASE64Encoder().encode(out.toByteArray());
        } catch (IOException e) {
            log.error("gzip压缩失败，原因如下：\n{}", e);
        }
        return null;
    }

    /**
     * gzip解压
     * @param compressedStr 压缩过的字符串
     * @return
     */
    public static String gunzip(String compressedStr) {
        String str=null;
        if (StrUtil.isNotBlank(compressedStr)) {
            try(
                    ByteArrayOutputStream out=new ByteArrayOutputStream();
                    ByteArrayInputStream in=new ByteArrayInputStream(new BASE64Decoder().decodeBuffer(compressedStr));
                    GZIPInputStream ginzip=new GZIPInputStream(in)
            ) {
                byte[] buf=new byte[1024];
                int offset=-1;
                while(-1 != (offset=ginzip.read(buf))) {
                    out.write(buf, 0, offset);
                }
                out.flush();
                str=out.toString();
            } catch (IOException e) {
                log.error("gzip解压失败，原因如下：\n{}", e);
            }
        }
        return str;
    }

    /**
     * zip压缩
     * @param str 未压缩的字符串
     * @return
     */
    public static final String zip(String str) {
        if(StrUtil.isBlank(str)) {return str;}

        try(
                ByteArrayOutputStream out=new ByteArrayOutputStream();
                ZipOutputStream zip=new ZipOutputStream(out)
        ) {
            zip.putNextEntry(new ZipEntry("0"));
            zip.write(str.getBytes());
            zip.closeEntry();
            return new BASE64Encoder().encodeBuffer(out.toByteArray());
        } catch (IOException e) {
            log.error("zip压缩失败，原因如下：\n{}", e);
        }
        return null;
    }

    /**
     * zip解压
     * @param compressedStr 压缩过的字符串
     * @return
     */
    public static final String unzip(String compressedStr) {
        String str=null;
        if (StrUtil.isNotBlank(compressedStr)) {
            try(
                    ByteArrayOutputStream out=new ByteArrayOutputStream();
                    ByteArrayInputStream in=new ByteArrayInputStream(new BASE64Decoder().decodeBuffer(compressedStr));
                    ZipInputStream zis=new ZipInputStream(in)
            ) {
                zis.getNextEntry();
                byte[] buf=new byte[1024];
                int offset=-1;
                while(-1 != (offset=zis.read(buf))) {
                    out.write(buf, 0, offset);
                }
                out.flush();
                str=out.toString();
            } catch (IOException e) {
                log.error("zip解压失败，原因如下：\n{}", e);
            }
        }
        return str;
    }
}