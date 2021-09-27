package com.example.usermanageapirest.domain.services;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

@Data
@Accessors(chain = true)
public class Sort {

	private final SortFields field;
	private final SortCriteria criteria;

	public enum SortFields {
		FIRSTNAME("firstName"),
		LASTNAME("lastName"),
		AGE("age"),
		COUNTRY_ID("countryId");

		private static Map<String, SortFields> map;

		private final String field;

		private SortFields(String field) {
			this.field = field;
		}

		public String getField() {
			return this.field;
		}

		public static boolean isSortFieldValid(String sortField) {
			return Arrays.stream(values()).anyMatch(sf -> sf.getField().equals(sortField));
		}

		public static SortFields fromField(String field) {
			if(isNull(map)) {
				map = new HashMap<>();

				for(SortFields sortField : SortFields.values()) {
					map.put(sortField.field, sortField);
				}
			}

			return map.get(field);
		}
	}

	public enum SortCriteria {
		ASC("asc"),
		DESC("desc");

		private final String criteria;

		private SortCriteria(String criteria) {
			this.criteria = criteria;
		}

		public String getCriteria() {
			return this.criteria;
		}

		public static boolean isSortCriteriaValid(String sortCriteria) {
			return Arrays.stream(values()).anyMatch(sc -> sc.getCriteria().equals(sortCriteria));
		}

		public boolean isSortCriteriaAsc() {
			return (SortCriteria.ASC.equals(this));
		}

		public boolean isSortCriteriaDesc() {
			return (SortCriteria.DESC.equals(this));
		}
	}
}
