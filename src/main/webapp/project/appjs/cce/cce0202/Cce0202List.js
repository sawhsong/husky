/**************************************************************************************************
 * Framework Generated Javascript Source
 * - Cce0202List.js
 *************************************************************************************************/
var popup;
var dateTimeFormat = jsconfig.get("dateTimeFormatJs");
var dateFormat = jsconfig.get("dateFormatJs");
var searchResultDataCount = 0;
var fileContextMenu = [];

$(function() {
	/*!
	 * event
	 */
	$("#btnSearch").click(function(event) {
		doSearch();
	});

	$("#btnClear").click(function(event) {
		commonJs.clearSearchCriteria();
	});

	$("#btnUpload").click(function(event) {
		popup = commonJs.openPopup({
			popupId:"UploadCreditCardStatement",
			url:"/cce/0202/getUpload.do",
			data:{},
			header:"Upload Credit Card Statement",
			width:1200,
			height:750
		});
	});

	$("#btnDelete").click(function(event) {
		doDelete();
	});

	$("#icnFromDate").click(function(event) {
		commonJs.openCalendar(event, "fromDate");
	});

	$("#icnToDate").click(function(event) {
		commonJs.openCalendar(event, "toDate");
	});

	$("#icnCheck").click(function(event) {
		commonJs.toggleCheckboxes("chkForDel");
	});

	$("#bankAccntId").change(function(event) {
		doSearch();
	});

	$(document).keydown(function(event) {
		var code = event.keyCode || event.which, element = event.target;

		if (code == 13) {
			if ($(element).is("#toDate")) {
				doSearch();
			}
		}

		if (code == 9) {}
	});

	/*!
	 * process
	 */
	doSearch = function() {
		commonJs.showProcMessageOnElement("divScrollablePanel");

		commonJs.doSearch({
			url:"/cce/0202/getList.do",
			onSuccess:renderDataGrid
		});
	};

	renderDataGrid = function(result) {
		var ds = result.dataSet;
		var html = "";

		searchResultDataCount = ds.getRowCnt();
		$("#tblGridBody").html("");

		if (ds.getRowCnt() > 0) {
			for (var i=0; i<ds.getRowCnt(); i++) {
				var gridTr = new UiGridTr();

				var uiChk = new UiCheckbox();
				uiChk.setName("chkForDel").setValue(ds.getValue(i, "CC_STATEMENT_ID"));
				gridTr.addChild(new UiGridTd().addClassName("Ct").addChild(uiChk));

				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "BANK_NAME")));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(commonJs.getFormatString(ds.getValue(i, "BSB"), "??? ???")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "ACCNT_NUMBER")));
				gridTr.addChild(new UiGridTd().addClassName("Lt").setText(ds.getValue(i, "ACCNT_NAME")));

				var uiAnc = new UiAnchor();
				uiAnc.setText(ds.getValue(i, "ORIGINAL_FILE_NAME")).setScript("getDetail('"+ds.getValue(i, "BANK_CODE")+"', '"+ds.getValue(i, "CC_STATEMENT_ID")+"')");
				gridTr.addChild(new UiGridTd().addClassName("Lt").addChild(uiAnc));

				gridTr.addChild(new UiGridTd().addClassName("Rt").setText(commonJs.getNumberMask(ds.getValue(i, "DETAIL_CNT"), "#,##0")));

				var gridTd = new UiGridTd();
				gridTd.addClassName("Ct");
				var iconFile = new UiIcon();
				iconFile.setId("iconFile").setName("iconFile").addClassName("glyphicon-paperclip").addAttribute("ccStatementId:"+ds.getValue(i, "CC_STATEMENT_ID")).setScript("getFile(this)");
				gridTd.addChild(iconFile);
				gridTr.addChild(gridTd);

				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(commonJs.getDateTimeMask(ds.getValue(i, "MIN_PROC_DATE"), dateFormat)));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(commonJs.getDateTimeMask(ds.getValue(i, "MAX_PROC_DATE"), dateFormat)));
				gridTr.addChild(new UiGridTd().addClassName("Ct").setText(commonJs.getDateTimeMask(ds.getValue(i, "LAST_UPDATE_DATE"), dateFormat)));

				html += gridTr.toHtmlString();
			}
		} else {
			var gridTr = new UiGridTr();

			gridTr.addChild(new UiGridTd().addClassName("Ct").setAttribute("colspan:11").setText(com.message.I001));
			html += gridTr.toHtmlString();
		}

		$("#tblGridBody").append($(html));

		$("#tblGrid").fixedHeaderTable({
			attachTo:$("#divDataArea"),
			pagingArea:$("#divPagingArea"),
			isPageable:true,
			totalResultRows:result.totalResultRows,
			script:"doSearch"
		});

		$("[name=iconFile]").each(function(index) {
			$(this).contextMenu(fileContextMenu);
		});

		commonJs.bindToggleTrBackgoundWithCheckbox($("[name=chkForDel]"));
		commonJs.hideProcMessageOnElement("divScrollablePanel");
	};

	doDelete = function() {
		if (commonJs.getCountChecked("chkForDel") == 0) {
			commonJs.warn(com.message.I902);
			return;
		}

		commonJs.doDelete({
			url:"/cce/0202/doDelete.do",
			callback:doSearch
		});
	};

	getDetail = function(bankCode, ccStatementId) {
		popup = commonJs.openPopup({
			popupId:"CreditCardStatementDetail",
			url:"/cce/0202/getDetail.do",
			noForm:true,
			data:{
				bankCode:bankCode,
				ccStatementId:ccStatementId
			},
			header:"Credit Card Statement Detail",
			width:1200,
			height:750
		});
	};

	getFile = function(img) {
		commonJs.doSimpleProcess({
			url:"/cce/0202/getFile.do",
			data:{ccStatementId:$(img).attr("ccStatementId")},
			onSuccess:function(result) {
				var dataSet = result.dataSet;
				fileContextMenu = [];

				for (var i=0; i<dataSet.getRowCnt(); i++) {
					var repositoryPath = dataSet.getValue(i, "REPOSITORY_PATH");
					var originalName = dataSet.getValue(i, "ORIGINAL_FILE_NAME");
					var newName = dataSet.getValue(i, "NEW_NAME");
					var fileIcon = dataSet.getValue(i, "FILE_ICON");
					var fileSize = (dataSet.getValue(i, "FILE_SIZE")/1024)+1;

					fileContextMenu.push({
						name:originalName+" ("+commonJs.getNumberMask(fileSize, "0,0")+") KB",
						title:originalName,
						img:fileIcon,
						repositoryPath:repositoryPath,
						originalName:originalName,
						newName:newName,
						fun:function() {
							var index = $(this).index();

							downloadFile({
								repositoryPath:fileContextMenu[index].repositoryPath,
								originalName:fileContextMenu[index].originalName,
								newName:fileContextMenu[index].newName
							});
						}
					});
				}

				$(img).contextMenu(fileContextMenu, {
					classPrefix:com.constants.ctxClassPrefixGrid,
					displayAround:"trigger",
					position:"bottom",
					horAdjust:0,
					verAdjust:2
				});
			}
		});
	};

	downloadFile = function(param) {
		commonJs.doSimpleProcessForPage({
			action:"/download.do",
			data:{
				repositoryPath:param.repositoryPath,
				originalName:param.originalName,
				newName:param.newName
			}
		});
	};

	/*!
	 * load event (document / window)
	 */
	$(window).load(function() {
		commonJs.setFieldDateMask("fromDate");
		commonJs.setFieldDateMask("toDate");

		doSearch();
	});
});