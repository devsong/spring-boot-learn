package com.gzs.learn.boot.util;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * http 请求工具类
 * 
 * @author guanzhisong
 * @date 2017年2月7日
 */
public class HttpUtil {
	private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	private static CloseableHttpClient client = HttpClientFactory.get();

	/**
	 * get 请求
	 *
	 * @param url
	 * @param headers
	 * @return
	 */
	public static <T> Response<T> doGet(String url, Class<? extends T> cls, Header... headers) {
		HttpUriRequest request = RequestBuilder.get(url).setConfig(HttpClientFactory.getDefaultRequestConfig()).build();
		if (headers != null && headers.length > 0) {
			request.setHeaders(headers);
		}
		return getResult(request, cls);
	}

	/**
	 * 获取list列表
	 * 
	 * @param url
	 * @param reference
	 * @param headers
	 * @return
	 */
	public static <T> Response<T> doGet(String url, TypeReference<List<T>> reference, Header... headers) {
		HttpUriRequest request = RequestBuilder.get(url).setConfig(HttpClientFactory.getDefaultRequestConfig()).build();
		if (headers != null && headers.length > 0) {
			request.setHeaders(headers);
		}
		return getResult(request, reference);
	}

	/**
	 * post请求
	 * 
	 * @param url
	 * @param pairs
	 * @param cls
	 * @param headers
	 * @return
	 */
	public static <T> Response<T> doPost(String url, List<? extends NameValuePair> pairs, Class<? extends T> cls,
			Header... headers) {
		HttpUriRequest request;
		if (pairs != null && pairs.size() > 0) {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs, StandardCharsets.UTF_8);
			request = RequestBuilder.post(url).setEntity(entity).setConfig(HttpClientFactory.getDefaultRequestConfig())
					.build();
		} else {
			request = RequestBuilder.post(url).setConfig(HttpClientFactory.getDefaultRequestConfig()).build();
		}

		if (headers != null && headers.length > 0) {
			request.setHeaders(headers);
		}
		return getResult(request, cls);
	}

	/**
	 * post请求
	 * 
	 * @param url
	 * @param pairs
	 * @param reference
	 * @param headers
	 * @return
	 */
	public static <T> Response<T> doPost(String url, List<? extends NameValuePair> pairs,
			TypeReference<List<T>> reference, Header... headers) {
		HttpUriRequest request;
		if (pairs != null && pairs.size() > 0) {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs, StandardCharsets.UTF_8);
			request = RequestBuilder.post(url).setEntity(entity).setConfig(HttpClientFactory.getDefaultRequestConfig())
					.build();
		} else {
			request = RequestBuilder.post(url).setConfig(HttpClientFactory.getDefaultRequestConfig()).build();
		}

		if (headers != null && headers.length > 0) {
			request.setHeaders(headers);
		}
		return getResult(request, reference);
	}

	/**
	 * post body请求体
	 * 
	 * @param url
	 * @param requestBody
	 * @param cls
	 * @param headers
	 * @return
	 */
	public static <T> Response<T> doPost(String url, String requestBody, Class<? extends T> cls, Header... headers) {
		HttpUriRequest request = null;
		if (StringUtils.isNotBlank(requestBody)) {
			StringEntity entity = new StringEntity(requestBody, StandardCharsets.UTF_8);
			request = RequestBuilder.post(url).setEntity(entity).setConfig(HttpClientFactory.getDefaultRequestConfig())
					.build();
		} else {
			request = RequestBuilder.post(url).setConfig(HttpClientFactory.getDefaultRequestConfig()).build();
		}
		if (headers != null && headers.length > 0) {
			request.setHeaders(headers);
		}
		return getResult(request, cls);
	}

	/**
	 * post body请求体
	 * 
	 * @param url
	 * @param requestBody
	 * @param reference
	 * @param headers
	 * @return
	 */
	public static <T> Response<T> doPost(String url, String requestBody, TypeReference<List<T>> reference,
			Header... headers) {
		HttpUriRequest request = null;
		if (StringUtils.isNotBlank(requestBody)) {
			StringEntity entity = new StringEntity(requestBody, StandardCharsets.UTF_8);
			request = RequestBuilder.post(url).setEntity(entity).setConfig(HttpClientFactory.getDefaultRequestConfig())
					.build();
		} else {
			request = RequestBuilder.post(url).setConfig(HttpClientFactory.getDefaultRequestConfig()).build();
		}
		if (headers != null && headers.length > 0) {
			request.setHeaders(headers);
		}
		return getResult(request, reference);
	}

	/**
	 * put请求
	 * 
	 * @param url
	 * @param pairs
	 * @param cls
	 * @param headers
	 * @return
	 */
	public static <T> Response<T> doPut(String url, List<? extends NameValuePair> pairs, Class<? extends T> cls,
			Header... headers) {
		HttpUriRequest request;
		if (pairs != null && pairs.size() > 0) {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs, StandardCharsets.UTF_8);
			request = RequestBuilder.put(url).setEntity(entity).setConfig(HttpClientFactory.getDefaultRequestConfig())
					.build();
		} else {
			request = RequestBuilder.post(url).setConfig(HttpClientFactory.getDefaultRequestConfig()).build();
		}

		if (headers != null && headers.length > 0) {
			request.setHeaders(headers);
		}
		return getResult(request, cls);
	}

	/**
	 * put请求
	 * 
	 * @param url
	 * @param pairs
	 * @param cls
	 * @param headers
	 * @return
	 */
	public static <T> Response<T> doPut(String url, List<? extends NameValuePair> pairs,
			TypeReference<List<T>> reference, Header... headers) {
		HttpUriRequest request;
		if (pairs != null && pairs.size() > 0) {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs, StandardCharsets.UTF_8);
			request = RequestBuilder.put(url).setEntity(entity).setConfig(HttpClientFactory.getDefaultRequestConfig())
					.build();
		} else {
			request = RequestBuilder.post(url).setConfig(HttpClientFactory.getDefaultRequestConfig()).build();
		}

		if (headers != null && headers.length > 0) {
			request.setHeaders(headers);
		}
		return getResult(request, reference);
	}

	/**
	 * do put请求体
	 * 
	 * @param url
	 * @param requestBody
	 * @param cls
	 * @param headers
	 * @return
	 */
	public static <T> Response<T> doPut(String url, String requestBody, Class<? extends T> cls, Header... headers) {
		HttpUriRequest request;
		if (StringUtils.isNotBlank(requestBody)) {
			StringEntity entity = new StringEntity(requestBody, StandardCharsets.UTF_8);
			request = RequestBuilder.put(url).setEntity(entity).setConfig(HttpClientFactory.getDefaultRequestConfig())
					.build();
		} else {
			request = RequestBuilder.post(url).setConfig(HttpClientFactory.getDefaultRequestConfig()).build();
		}

		if (headers != null && headers.length > 0) {
			request.setHeaders(headers);
		}
		return getResult(request, cls);
	}

	/**
	 * do put请求体
	 * 
	 * @param url
	 * @param requestBody
	 * @param cls
	 * @param headers
	 * @return
	 */
	public static <T> Response<T> doPut(String url, String requestBody, TypeReference<List<T>> reference,
			Header... headers) {
		HttpUriRequest request;
		if (StringUtils.isNotBlank(requestBody)) {
			StringEntity entity = new StringEntity(requestBody, StandardCharsets.UTF_8);
			request = RequestBuilder.put(url).setEntity(entity).setConfig(HttpClientFactory.getDefaultRequestConfig())
					.build();
		} else {
			request = RequestBuilder.post(url).setConfig(HttpClientFactory.getDefaultRequestConfig()).build();
		}

		if (headers != null && headers.length > 0) {
			request.setHeaders(headers);
		}
		return getResult(request, reference);
	}

	/**
	 * delete方法
	 *
	 * @param url
	 * @param headers
	 * @return
	 */
	public static <T> Response<T> doDelete(String url, Class<? extends T> cls, Header... headers) {
		HttpUriRequest request = RequestBuilder.delete(url).setConfig(HttpClientFactory.getDefaultRequestConfig())
				.build();
		if (headers != null && headers.length > 0) {
			request.setHeaders(headers);
		}
		return getResult(request, cls);
	}

	/**
	 * head 请求
	 * 
	 * @param url
	 * @param headers
	 * @return
	 */
	public static Integer doHead(String url, Header... headers) {
		HttpUriRequest request = RequestBuilder.head(url).setConfig(HttpClientFactory.getDefaultRequestConfig())
				.build();
		if (headers != null && headers.length > 0) {
			request.setHeaders(headers);
		}

		return getResult(request, String.class).httpCode;
	}

	/**
	 * 构造http url get 请求串
	 *
	 * @param url
	 * @param pairs
	 * @return
	 */
	public static String buildUrl(String url, List<? extends NameValuePair> pairs) {
		if (CollectionUtils.isEmpty(pairs)) {
			return url;
		}
		return url + "?" + pairs.stream().filter((entry) -> StringUtils.isNotBlank(entry.getValue())).map((entry) -> {
			return entry.getName() + "=" + entry.getValue();
		}).collect(Collectors.joining("&"));
	}

	/**
	 * map to list<NameValuePair>
	 *
	 * @param params
	 * @return
	 */
	public static List<NameValuePair> convertMap2Pair(Map<String, ? extends Object> params) {
		if (params == null || params.size() == 0) {
			return null;
		}
		return params.entrySet().stream().filter((entry) -> entry.getValue() != null).map((entry) -> {
			return new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
		}).collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	private static <T> Response<T> getResult(HttpUriRequest request, Class<? extends T> cls) {
		int code = 0;
		boolean success = false;
		T obj = null;
		String errMsg = null;
		try {
			HttpResponse response = client.execute(request);
			code = response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();
			String resp = entity == null ? "" : EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
			if (code / 100 == 2) {
				success = true;
				if (cls.getName().equals("java.lang.String")) {
					obj = (T) resp;
				} else {
					obj = JSON.parseObject(resp, cls);
				}
			} else {
				errMsg = resp;
			}
		} catch (Exception e) {
			logger.error("Catch exception when getResult,", e);
		}
		return new Response<T>(success, code, obj, errMsg);
	}

	private static <T> Response<T> getResult(HttpUriRequest request, TypeReference<List<T>> reference) {
		int code = 0;
		boolean success = false;
		List<T> list = null;
		String errMsg = null;
		try (CloseableHttpResponse response = client.execute(request)) {
			code = response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();
			String resp = entity == null ? "" : EntityUtils.toString(entity, StandardCharsets.UTF_8);
			if (code / 100 == 2) {
				success = true;
				list = JSON.parseObject(resp, reference);
			} else {
				errMsg = resp;
			}
		} catch (Exception e) {
			logger.error("Catch exception when getResult List,", e);
		}
		return new Response<T>(success, code, list, errMsg);
	}

	public static class Response<T> {
		public boolean success;
		public int httpCode;
		public T entity;
		public List<T> list;
		public String errMsg;

		public Response() {
		}

		public Response(boolean success, int httpCode, T entity, String errMsg) {
			this.success = success;
			this.httpCode = httpCode;
			this.entity = entity;
			this.errMsg = errMsg;
		}

		public Response(boolean success, int httpCode, List<T> list, String errMsg) {
			this.success = success;
			this.httpCode = httpCode;
			this.list = list;
			this.errMsg = errMsg;
		}
	}
}