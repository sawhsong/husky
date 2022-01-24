/**
* common JavaScript
* 	- provides users interface methods on behalf of nony javascript library.
* Caution : The methods which start with '_' are all private methods. Do not use these methods in projects directly.
*/
var commonJs = {
	/*!
	 * information
	 */
	version : $.nony.version,
	browser : $.nony.browser,
	isPopup : function() {return $.nony.isPopup();},
	isNormalPage : function() {return $.nony.isNormalPage();},
	/*!
	 * form operating
	 */
	submit : function(params) {$.nony.submit(params);},
	doSubmit : function(params) {$.nony.doSubmit(params);},
	serialiseForm : function(jqForm) {return $.nony.serialiseForm(jqForm);},
	serialiseObject : function(jqObject) {return $.nony.serialiseObject(jqObject);},
	/*!
	 * ajax
	 */
	ajax : function(params) {$.nony.ajax.ajax(params);},
	ajaxSubmit : function(params) {$.nony.ajax.ajaxSubmit(params);},
	ajaxSubmitMultipart : function(params) {$.nony.ajax.ajaxSubmitMultipart(params);},
	parseAjaxResult : function(data, textStatus, dataType) {return $.nony.ajax.parseAjaxResult(data, textStatus, dataType);},
	getFormDataFromSerializedArray : function(formSerializedArray) {return $.nony.ajax.getFormDataFromSerializedArray(formSerializedArray);},
	/*!
	 * number utilities
	 */
	isNumber : function(val) {return $.nony.isNumber(val);},
	toNumber : function(val) {return $.nony.toNumber(val);},
	ceil : function(number, scale) {return $.nony.ceil(number, scale);},
	round : function(number, scale) {return $.nony.round(number, scale);},
	floor : function(number, scale) {return $.nony.floor(number, scale);},
	getNumberMask : function(number, format) {return $.nony.getNumberMask(number, format);},
	getAccountingFormat : function(val) {return $.nony.getAccountingFormat(val);},
	getParenthesisFormat : function(val) {return $.nony.getParenthesisFormat(val);},
	/*!
	 * string utilities
	 */
	isEmpty : function(val) {return $.nony.isEmpty(val);},
	isBlank : function(val) {return $.nony.isBlank(val);},
	isNotEmpty : function(val) {return $.nony.isNotEmpty(val);},
	isNotBlank : function(val) {return $.nony.isNotBlank(val);},
	isIn : function(val, vals) {return $.nony.isIn(val, vals);},
	isInIgnoreCase : function(val, vals) {return $.nony.isInIgnoreCase(val, vals);},
	nvl : function(val, defaultVal) {return $.nony.nvl(val, defaultVal);},
	trim : function(val) {return $.nony.trim(val);},
	upperCase : function(val) {return $.nony.upperCase(val);},
	lowerCase : function(val) {return $.nony.lowerCase(val);},
	toCamelCase : function(val) {return $.nony.toCamelCase(val);},
	replace : function(src, from, to) {return $.nony.replace(src, from, to);},
	removeString : function(src, val) {return $.nony.removeString(src, val);},
	lpad : function(src, len, pad) {return $.nony.lpad(src, len, pad);},
	rpad : function(src, len, pad) {return $.nony.rpad(src, len, pad);},
	startsWith : function(src, prefix) {return $.nony.startsWith(src, prefix);},
	endsWith : function(src, suffix) {return $.nony.endsWith(src, suffix);},
	contains : function(src, val) {return $.nony.contains(src, val);},
	containsIgnoreCase : function(src, val) {return $.nony.containsIgnoreCase(src, val);},
	getFormatString : function(source, format) {return $.nony.getFormatString(source, format);},
	abbreviate : function(val, length) {return $.nony.abbreviate(val, length);},
	toBoolean : function(val) {return $.nony.toBoolean(val);},
	htmlToString : function(val) {return $.nony.htmlToString(val);},
	stringToHtml : function(val) {return $.nony.stringToHtml(val);},
	/*!
	 * date utilities(use moment.js)
	 */
	getSysdate : function(format) {return $.nony.getSysdate(format);},
	getFormatDateTime : function(value, format) {return $.nony.getFormatDateTime(value, format);},
	getDateTimeMask : function(value, format) {return $.nony.getDateTimeMask(value, format);},
	getTimeStamp : function(format) {return $.nony.getTimeStamp(format);},
	getUid : function() {return $.nony.getUid();},
	/*!
	 * validator
	 */
	doValidate : function(anyObject) {return $.nony.validator.doValidate(anyObject);},
	getElementsToCheckValidation : function(formId, elementArray, selectOption) {return $.nony.validator.getElementsToCheckValidation(formId, elementArray, selectOption);},
	doErrorMessage : function(msgType) {return $.nony.validator.doErrorMessage(msgType);},
	doValidatorMessage : function(jQueryElement, msgType) {return $.nony.validator.doValidatorMessage(jQueryElement, msgType);},
	isUploadableImageFile : function(jQueryElement, elementValue) {return $.nony.validator.isUploadableImageFile(jQueryElement, elementValue);},
	/*!
	 * utilities etc
	 */
	removeArrayItem : function(array, name) {return $.nony.removeArrayItem(array, name);},
	getIconNameByFileType : function(fileType) {return $.nony.getIconNameByFileType(fileType);},
	copyToClipboard : function(value) {$.nony.copyToClipboard(value);},
	downloadContentAsFile : function(fileName, value) {$.nony.downloadContentAsFile(fileName, value);},
	/*!
	 * popup / dialog / calendar
	 */
	openWindow : function(params) {return $.nony.openWindow(params);},
	openPopup : function(params) {return $.nony.openPopup(params);},
	openDialog : function(params) {return $.nony.openDialog(params);},
	alert : function(msg) {return $.nony.alert(msg);},
	inform : function(msg) {return $.nony.alert(msg);},
	confirm : function(params) {return $.nony.confirm(params);},
	warn : function(msg) {return $.nony.warn(msg);},
	error : function(msg) {return $.nony.error(msg);},
	openCalendar : function(event, txtObjectId, options) {return $.nony.openCalendar(event, txtObjectId, options);},
	openContextMenu : function(event, options) {return $.nony.contextMenu.showMenu(event, options);},
	/*!
	 * screen blind
	 */
	showProcMessage : function(msg) {$.nony.showProcMessage(msg);},
	hideProcMessage : function() {$.nony.hideProcMessage();},
	showProcMessageOnElement : function(blockElementId, msg) {$.nony.showProcMessageOnElement(blockElementId, msg);},
	hideProcMessageOnElement : function(blockElementId) {$.nony.hideProcMessageOnElement(blockElementId);},
	/*!
	 * controlling tab
	 */
	changeTabSelection : function(object) {$.nony.changeTabSelection(object);},
	getSelectedTabIndex : function(object) {return $.nony.getSelectedTabIndex(object);},
	/*!
	 * jQuery UI
	 */
	setAccordion : function(params) {$.nony.setAccordion(params);},
	expandAllAccordion : function(params) {$.nony.expandAllAccordion(params);},
	getBootstrapSelectbox : function(id) {return $.nony.getBootstrapSelectbox(id);},
	refreshBootstrapSelectbox : function(id) {return $.nony.refreshBootstrapSelectbox(id);},
	setSelectpickerValue : function(elementId, selectedValue) {$.nony.setSelectpickerValue(elementId, selectedValue);},
	setAutoComplete : function(jqObject, param) {$.nony.setAutoComplete(jqObject, param);},
	initSelectpicker : function() {$.nony._jqSelectmenu();},
	/*!
	 * UI Elements
	 */
	getUiTextbox : function(params) {return uiElements.getUiTextbox(params);},
	getUiHidden : function(params) {return uiElements.getUiHidden(params);},
	getUiRadio : function(params) {return uiElements.getUiRadio(params);},
	getUiSelectOption : function(params) {return uiElements.getUiSelectOption(params);},
	getUiSelectOptionWithCommonCode : function(params) {return uiElements.getUiSelectOptionWithCommonCode(params);},
	getUiImage : function(params) {return uiElements.getUiImage(params);},
	getUiIcon : function(params) {return uiElements.getUiIcon(params);},
	/*!
	 * controlling file elements
	 */
	modifyFileSelectObject : function(objects) {$.nony.fileElement.modifyFileSelectObject(objects);},
	addFileSelectObject : function(params) {$.nony.fileElement.addFileSelectObject(params);},
	/*!
	 * create DataSet
	 */
	getDataSetFromJavaDataSet : function(dataSetString) {return $.nony.getDataSetFromJavaDataSet(dataSetString);},
	/*!
	 * Logging on console
	 */
	printLog : function(params) {$.nony.printLog(params);},
	/*!
	 * Bind event and function
	 */
	setEvent : function(eventName, objArr, callback) {$.nony.setEvent(eventName, objArr, callback);},
	clearValueOnBlur : function(jqObj) {$.nony.clearValueOnBlur(jqObj);},
	/*!
	 * etc
	 */
	setFieldDateMask : function(elementId) {$.nony.setFieldDateMask(elementId);},
	setFieldNumberMask : function(elementId, format) {$.nony.setFieldNumberMask(elementId, format);},
	toggleCheckboxes : function(elementName) {$.nony.toggleCheckboxes(elementName);},
	bindToggleTrBackgoundWithCheckbox : function(jqObject) {$.nony.bindToggleTrBackgoundWithCheckbox(jqObject);},
	bindToggleTrBackgoundWithRadiobox : function(jqObject) {$.nony.bindToggleTrBackgoundWithRadiobox(jqObject);},
	getCountChecked : function(checkboxName) {return $.nony.getCountChecked(checkboxName);},
	setCheckboxValue : function(checkboxName, value) {$.nony.setCheckboxValue(checkboxName, value);},
	getCheckedValueFromRadio : function(radioName) {return $.nony.getCheckedValueFromRadio(radioName);},
	getCheckedValueFromCheckbox : function(jqObject) {return $.nony.getCheckedValueFromCheckbox(jqObject);},
	setRadioValue : function(radioName, value) {$.nony.setRadioValue(radioName, value);},
	clearSearchCriteria : function() {$.nony.clearSearchCriteria();},
	isSearchCriteriaSelected : function() {return $.nony.isSearchCriteriaSelected();},
	clearPaginationValue : function() {$.nony.clearPaginationValue();},
	setExportButtonContextMenu : function(jqObjectButton) {$.nony.setExportButtonContextMenu(jqObjectButton);},
	/*!
	 * process wrappers - for ajax
	 */
	doSearch : function(params) {$.nony.doSearch(params);},
	doSimpleProcess : function(params) {$.nony.doSimpleProcess(params);},
	doProcess : function(params) {$.nony.doProcess(params);},
	doProcessWithFile : function(params) {$.nony.doProcessWithFile(params);},
	doSave : function(params) {$.nony.doSave(params);},
	doSaveWithFile : function(params) {$.nony.doSaveWithFile(params);},
	doDelete : function(params) {$.nony.doDelete(params);},
	doExport : function(params) {$.nony.doExport(params);},
	/*!
	 * process wrappers - for page submit
	 */
	doSimpleProcessForPage : function(params) {$.nony.doSimpleProcessForPage(params);},
	doProcessForPage : function(params) {$.nony.doProcessForPage(params);},
	doProcessWithFileForPage : function(params) {$.nony.doProcessWithFileForPage(params);},
	doSaveForPage : function(params) {$.nony.doSaveForPage(params);},
	doSaveWithFileForPage : function(params) {$.nony.doSaveWithFileForPage(params);},
	doDeleteForPage : function(params) {$.nony.doDeleteForPage(params);},
	/*!
	 * controlling page load operations
	 */
	getPageLayoutOptions : function() {
		var defaultOuterLayoutOption = {
			name:"defaultOuterLayoutOption",
			fxName:"slide",
			fxSpeed:"slow",
			spacing_open:0,
			spacing_closed:0,
//			spacing_open:4,
//			spacing_closed:4,
			togglerLength_open:0,
			togglerLength_closed:0,
//			togglerLength_open:40,
//			togglerLength_closed:40,
			north__resizerClass:"northLayoutResizers",
			south__resizerClass:"southLayoutResizers",
			togglerClass:"layoutTogglers",
			north__resizable:false,
			north__slideTrigger_open:"mouseover",
			south__resizable:false,
			south__initClosed:false,
			onresize_end:function() {
//				$(window).trigger("resize");
//				try {
//					doSearch();
//				} catch(e) {}
			}
		};

		var defaultInnerLayoutOption;
		if (jsconfig.get("noWest")) {
			defaultInnerLayoutOption = {
				name:"defaultInnerLayoutOption",
				fxName:"fade",
				fxSpeed:"fast",
//				spacing_open:0,
//				spacing_closed:0,
				spacing_open:0,
				spacing_closed:0,
//				togglerLength_open:0,
//				togglerLength_closed:0,
				togglerLength_open:40,
				togglerLength_closed:40,
				resizerClass:"layoutResizers",
				togglerClass:"layoutTogglers",
				east__size:0,
				east__initClosed:true,
				east__initHidden:true,
				west__initClosed:true,
				west__initHidden:true,
				west__size:0,
				onresize_end:function() {
//					$(window).trigger("resize");
//					try {
//						doSearch();
//					} catch(e) {}
				}
			};
		} else {
			defaultInnerLayoutOption = {
				name:"defaultInnerLayoutOption",
				fxName:"fade",
				fxSpeed:"fast",
//				spacing_open:0,
//				spacing_closed:0,
				spacing_open:0,
				spacing_closed:0,
//				togglerLength_open:0,
//				togglerLength_closed:0,
				togglerLength_open:40,
				togglerLength_closed:40,
				resizerClass:"layoutResizers",
				togglerClass:"layoutTogglers",
				east__size:0,
				east__initClosed:true,
				east__initHidden:true,
				west__size:250,
				west__minSize:0,
				onresize_end:function() {
//					$(window).trigger("resize");
					try {
//						doSearch();
					} catch(e) {}
				}
			};
		}

		return [defaultOuterLayoutOption, defaultInnerLayoutOption];
	}
};
/*!
 * 1
 */
$(document).ready(function() {
});
/*!
 * 2
 */
$(window).ready(function() {
	if (!($.nony.isPopup() || $.nony.isTabFrame())) {$.nony._doPageLayout(commonJs.getPageLayoutOptions());}
});
/*!
 * 3
 */
$(window).load(function() {
	if (!$.nony.isPopup()) {$.nony._doPageLoadEffect();}

	$.nony.fileElement.modifyFileSelectObject();

	if ("Y" == jsconfig.get("autoSetSearchCriteria")) {$.nony._setAutoSearchCriteria(jsconfig.get("searchCriteriaDataSetString"));}
	if (jsconfig.get("useScrollablePanel")) {$.nony._doResizeScrollablePanel();}
	if (jsconfig.get("useJqTooltip")) {$.nony._jqTooltip();}
	if (jsconfig.get("useJqSelectmenu")) {
		setTimeout(function() {
			$.nony._jqSelectmenu();
		}, $.nony.nvl(jsconfig.get("jqSelectmenuInterval"), 0));
	}
});

/*!
 * resize event
 */
$(window).resize(function() {
	// Caution - consider resize start/end
});