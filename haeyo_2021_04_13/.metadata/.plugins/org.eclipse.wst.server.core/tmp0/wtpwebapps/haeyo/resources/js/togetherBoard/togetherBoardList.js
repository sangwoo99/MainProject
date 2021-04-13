	//북마크
	function tBookmark(tNo){
		var bookmark = $('#'+tNo).text();
		console.log("tNo: "+tNo+", bookmark: "+bookmark);
		var param = {"tNo":tNo,"bookmark":bookmark}; 
		$.ajax({
			url:"t_checkBookmark.do",
			type: "GET",
			contentType : "application/json; charset=UTF-8",
			data: param,
			success: function(result){
				console.log(result);
				
				if(result == 1){
					$('#'+tNo).addClass('select');
					$('#'+tNo).text(1);
				}else if(result == 0){
					$('#'+tNo).removeClass('select');
					$('#'+tNo).text(0);
				}
			}
		});
	}
	
	//카테고리별 리스트
	function getTboardList(tHeader, nowPage){
		resetButtonColor();
		var param = {"tHeader": tHeader, "nowPage": nowPage};
		console.log(param);
		$.ajax({
			url:"t_getBoardList.do",
			type:"GET",
			contentType: "application/json; charset=UTF-8",
			data: param,
			success: function(result){
				var boardList = result.boardList;
				var paging = result.paging;
				console.log(result);
				
				//글 목록 출력
				var html1 = getCommonBoardList(boardList);
				$('#t_content_box').html(html1);
				
				//페이징 출력부분
				var html = "";
				html += '<ul class="pagination">'
				
				if(paging.startPage == 1){
					html += '	<li class="page-item disabled">'
					html += '		<a class="page-link" href="#" >&laquo;</a></li>'
				}else{
					html += '	<li class="page-item">'
					html += '		<a class="page-link" href="#" onclick="getTboardList(\''+tHeader+'\','+(paging.startPage-1)+'); return false;">&laquo;</a></li>'
				}
										
				for(i = paging.startPage; i <= paging.endPage; i++){
					html += '<li class="page-item '+ (paging.nowPage == i ? "active" : "") +'">'
					html +=   '<a class="page-link" href="#" onclick="getTboardList(\''+tHeader+'\','+i+'); return false;">'+i+'</a>'
					html += '</li>'
				}
				
			    if(paging.endPage == paging.lastPage){
			    	html += '<li class="page-item disabled">'
			    	html += '		<a class="page-link" href="#" >&laquo;</a></li>'
			    }else{
			    	html += '<li class="page-item">'
			    	html += '		<a class="page-link" href="#" onclick="getTboardList(\''+tHeader+'\','+(paging.endPage+1)+'); return false;">&raquo;</a></li>'
			    }
			    html +='</ul>';
			  
				$('#paging_box').html(html);
			}
		});
		
		$('#writingBoard').show();
		$('#sort_buttons').show();
	}
	
	
	//검색창
	function searchBoardList(nowPage){
		if(nowPage == null){
			nowPage = 1;
		}
		var searchInput = $('#searchInput').val();
		var param = {"searchInput": searchInput,"nowPage":nowPage};
		console.log(param);
		$.ajax({
			url:"t_searchBoardList.do",
			type:"GET",  //문제
			contentType:"application/json; charset=utf-8",
			data:param,
			dataType:"json",
			success: function(result){
				console.log(result);
				var paging = result.paging;
				var boardList = result.boardList;
				
				var html= "<div style='font-size:20px'>검색결과</div>";
				//공통 출력 부분
				html += getCommonBoardList(boardList);
				$('#t_content_box').html(html);
				$('#sort_buttons').hide();
				$('#writingBoard').hide();
				
				//페이징 출력부분
				var html = "";
				html += '<ul class="pagination">'
				
				if(paging.startPage == 1){
					html += '	<li class="page-item disabled">'
					html += '		<a class="page-link" href="#" >&laquo;</a></li>'
				}else{
					html += '	<li class="page-item">'
					html += '		<a class="page-link" href="#" onclick="searchBoardList('+(paging.startPage-1)+')">&laquo;</a></li>'
				}
										
				for(i = paging.startPage; i <= paging.endPage; i++){
					html += '<li class="page-item '+ (paging.nowPage == i ? "active" : "") +'">'
					html +=   '<a class="page-link" href="#" onclick="searchBoardList('+i+')">'+i+'</a>'
					html += '</li>'
				}
				
			    if(paging.endPage == paging.lastPage){
			    	html += '<li class="page-item disabled">'
			    	html += '		<a class="page-link" href="#" >&laquo;</a></li>'
			    }else{
			    	html += '<li class="page-item">'
			    	html += '		<a class="page-link" href="#" onclick="searchBoardList('+(paging.endPage+1)+')">&raquo;</a></li>'
			    }
			    html +='</ul>';
			  
				$('#paging_box').html(html);
//				$('#searchInput').val('');
				$('#previewSearch').hide();
			}
		});
	//	$("span:contains('홍대')").css("color", "blue");  글자색바꾸기 나중에
	//	$("#tTitle:contains('"+searchInput+"')").css("color", "blue");
	}
	
	//검색창 자동완성(미리보기)
	function previewBoardList(){
		var searchInput = $('#searchInput').val();
		if(searchInput != ''){
			var param = {"searchInput": searchInput};
			console.log(param);
			$.ajax({
				url:"t_previewBoardList.do",
				type:"GET", 
				contentType:"application/json; charset=utf-8",
				data:param,
				dataType:"json",
				success: function(result){
					console.log(result);
					var html= "";
					for(i in result){
						html += "<a href='t_getBoard.do?tNo="+result[i].tNo+"'>"+result[i].tTitle+"</a></br>"
					}
					$('#previewSearch').html(html).show();
				}
			});
		}else{
			$('#previewSearch').hide();
			
		}
	} 
	
	//분류별 정렬
	function sortBoardList(sortInput, tHeader, nowPage){
		var param = {"sortInput": sortInput,"tHeader": tHeader,"nowPage": nowPage};
		console.log(param);
		console.log(event.target.classList[0]);
		var eTarget = event.target.classList[0];
		//버튼 색 변경
		if(eTarget == 'sort_button'){
			changeButtonColor(event);
		}
		$.ajax({
			url:"t_sortBoardList.do",
			type:"get",
			contentType:"application/json; charset=utf-8",
			data:param,
			dataType: "json",
			success: function(result){
				console.log(result);
				var boardList = result.boardList;
				var paging = result.paging;
				
				//공통 출력 부분
				var html = getCommonBoardList(boardList);
				$('#t_content_box').html(html);
			
				//페이징 출력부분
				var html = "";
				html += '<ul class="pagination">'
				
				if(paging.startPage == 1){
					html += '	<li class="page-item disabled">'
					html += '		<a class="page-link" href="#" >&laquo;</a></li>'
				}else{
					html += '	<li class="page-item">'
					html += '		<a class="page-link" href="#" onclick="sortBoardList(\''+sortInput+'\',\''+tHeader+'\','+(paging.startPage-1)+')">&laquo;</a></li>'
				}
										
				for(i = paging.startPage; i <= paging.endPage; i++){
					html += '<li class="page-item '+ (paging.nowPage == i ? "active" : "") +'">'
					html +=   '<a class="page-link" href="#" onclick="sortBoardList(\''+sortInput+'\',\''+tHeader+'\','+i+')">'+i+'</a>'
					html += '</li>'
				}
				
			    if(paging.endPage == paging.lastPage){
			    	html += '<li class="page-item disabled">'
			    	html += '		<a class="page-link" href="#" >&laquo;</a></li>'
			    }else{
			    	html += '<li class="page-item">'
			    	html += '		<a class="page-link" href="#" onclick="sortBoardList(\''+sortInput+'\',\''+tHeader+'\','+(paging.endPage+1)+')">&raquo;</a></li>'
			    }
			    html +='</ul>';
			  
				$('#paging_box').html(html);
			}
		});
	}
	
	//공통 리스트 출력  메서드
	function getCommonBoardList(boardList){
		var html= "";
		for(i in boardList){
			console.log(boardList[i].tBookmarkVO);
			html += "<div id='t_content'>"
			html +=	"  <div id='tAddress_Bookmark' class='clearfix'>"
			
			if(boardList[i].tDestinationVO != null){
				html += "    <div id='tAddress'>"+boardList[i].tAddress+"</div>"    //+"=>"+boardList[i].tDestinationVO.dAddress
			}else{
				html += "    <div id='tAddress'>"+boardList[i].tAddress+"</div>"
			}
			
			if(boardList[i].tBookmarkVO != null){
				html += "    	<div class='tBookmark select' id='"+boardList[i].tNo+"' onclick='tBookmark("+boardList[i].tNo+")'>1</div>"
			}else{
				html += "    	<div class='tBookmark' id='"+boardList[i].tNo+"' onclick='tBookmark("+boardList[i].tNo+")'>0</div>"
			}
			
			html += "  </div>"
			html += "  <div id='imgWrap'>"	
			html += "		<a href='t_getBoard.do?tNo="+boardList[i].tNo+"'> <img src='/WEB-INF/boardImages/"+boardList[i].tPic1+"' height='250' width='250'></a>"	
			html += "  </div>"	
			html += "  <div id='tTitle'>"+boardList[i].tTitle+"("+boardList[i].tJoinNow+"/"+boardList[i].tJoinMax+")</div>"
			html += "  <div id='tHeader'>"
			html += "		<button type='submit' class='heayo_btn'>"+boardList[i].tHeader+"</button>"
			html += "  </div>"
			html += "  <div id='t_hits'>조회"+boardList[i].tHits+"</div>"
			html += "</div>"
		}
		
		return html;
	}
	
	
	
	//버튼색 변경
	var div2 = document.getElementsByClassName("sort_button");
	function changeButtonColor(event){
          for (var i = 0; i < div2.length; i++) {
            div2[i].classList.remove("clicked");
            div2[i].classList.add("heayo_btn");
          }

          event.target.classList.add("clicked");
     }
	
	function resetButtonColor(){
		for (var i = 0; i < div2.length; i++) {
            div2[i].classList.remove("clicked");
            div2[i].classList.add("heayo_btn");
          }
	}
	
