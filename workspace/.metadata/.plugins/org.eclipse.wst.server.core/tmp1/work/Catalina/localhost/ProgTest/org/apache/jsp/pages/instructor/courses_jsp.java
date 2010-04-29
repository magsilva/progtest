package org.apache.jsp.pages.instructor;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class courses_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ff_005fsubview_0026_005fid;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fh_005fform;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fh_005fpanelGrid_0026_005fstyle_005fcolumns_005fcolumnClasses;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtm_005fdiv_0026_005fstyle;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005faf_005fspacer_0026_005fheight_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fstyleClass_005frendered_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005faf_005fspacer_0026_005frendered_005fheight_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fh_005fdataTable_0026_005fwidth_005fvar_005fvalue_005frendered_005fbinding;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fh_005fcolumn;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fh_005fcommandLink_0026_005fstyleClass_005faction;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fstyleClass_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fh_005fpanelGrid_0026_005fcolumns;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005faf_005fimage_0026_005fsource_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fh_005fpanelGrid_0026_005frendered_005fcolumns;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005faf_005fspacer_0026_005fwidth_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fhtm_005fdiv_0026_005fstyle_005frendered;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ff_005fconvertDateTime_0026_005fpattern_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005ff_005fsubview_0026_005fid = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fh_005fform = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fh_005fpanelGrid_0026_005fstyle_005fcolumns_005fcolumnClasses = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtm_005fdiv_0026_005fstyle = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005faf_005fspacer_0026_005fheight_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fstyleClass_005frendered_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005faf_005fspacer_0026_005frendered_005fheight_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fh_005fdataTable_0026_005fwidth_005fvar_005fvalue_005frendered_005fbinding = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fh_005fcolumn = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fh_005fcommandLink_0026_005fstyleClass_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fstyleClass_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fh_005fpanelGrid_0026_005fcolumns = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005faf_005fimage_0026_005fsource_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fh_005fpanelGrid_0026_005frendered_005fcolumns = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005faf_005fspacer_0026_005fwidth_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fhtm_005fdiv_0026_005fstyle_005frendered = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ff_005fconvertDateTime_0026_005fpattern_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ff_005fsubview_0026_005fid.release();
    _005fjspx_005ftagPool_005fh_005fform.release();
    _005fjspx_005ftagPool_005fh_005fpanelGrid_0026_005fstyle_005fcolumns_005fcolumnClasses.release();
    _005fjspx_005ftagPool_005fhtm_005fdiv_0026_005fstyle.release();
    _005fjspx_005ftagPool_005faf_005fspacer_0026_005fheight_005fnobody.release();
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fstyleClass_005frendered_005fnobody.release();
    _005fjspx_005ftagPool_005faf_005fspacer_0026_005frendered_005fheight_005fnobody.release();
    _005fjspx_005ftagPool_005fh_005fdataTable_0026_005fwidth_005fvar_005fvalue_005frendered_005fbinding.release();
    _005fjspx_005ftagPool_005fh_005fcolumn.release();
    _005fjspx_005ftagPool_005fh_005fcommandLink_0026_005fstyleClass_005faction.release();
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fstyleClass_005fnobody.release();
    _005fjspx_005ftagPool_005fh_005fpanelGrid_0026_005fcolumns.release();
    _005fjspx_005ftagPool_005faf_005fimage_0026_005fsource_005fnobody.release();
    _005fjspx_005ftagPool_005fh_005fpanelGrid_0026_005frendered_005fcolumns.release();
    _005fjspx_005ftagPool_005faf_005fspacer_0026_005fwidth_005fnobody.release();
    _005fjspx_005ftagPool_005fhtm_005fdiv_0026_005fstyle_005frendered.release();
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue.release();
    _005fjspx_005ftagPool_005ff_005fconvertDateTime_0026_005fpattern_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=iso-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      if (_jspx_meth_f_005fsubview_005f0(_jspx_page_context))
        return;
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_f_005fsubview_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:subview
    com.sun.faces.taglib.jsf_core.SubviewTag _jspx_th_f_005fsubview_005f0 = new com.sun.faces.taglib.jsf_core.SubviewTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_f_005fsubview_005f0);
    _jspx_th_f_005fsubview_005f0.setPageContext(_jspx_page_context);
    _jspx_th_f_005fsubview_005f0.setParent(null);
    // /pages/instructor/courses.jsp(11,26) name = id type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_f_005fsubview_005f0.setId("content");
    _jspx_th_f_005fsubview_005f0.setJspId("jsp_1042474162_0");
    int _jspx_eval_f_005fsubview_005f0 = _jspx_th_f_005fsubview_005f0.doStartTag();
    if (_jspx_eval_f_005fsubview_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_f_005fsubview_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_f_005fsubview_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_f_005fsubview_005f0.doInitBody();
      }
      do {
        if (_jspx_meth_h_005fform_005f0(_jspx_th_f_005fsubview_005f0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_f_005fsubview_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_f_005fsubview_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_f_005fsubview_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_f_005fsubview_005f0.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_f_005fsubview_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ff_005fsubview_0026_005fid.reuse(_jspx_th_f_005fsubview_005f0);
    return false;
  }

  private boolean _jspx_meth_h_005fform_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_f_005fsubview_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:form
    com.sun.faces.taglib.html_basic.FormTag _jspx_th_h_005fform_005f0 = new com.sun.faces.taglib.html_basic.FormTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005fform_005f0);
    _jspx_th_h_005fform_005f0.setPageContext(_jspx_page_context);
    _jspx_th_h_005fform_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_f_005fsubview_005f0);
    _jspx_th_h_005fform_005f0.setJspId("jsp_1042474162_1");
    int _jspx_eval_h_005fform_005f0 = _jspx_th_h_005fform_005f0.doStartTag();
    if (_jspx_eval_h_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_h_005fform_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_h_005fform_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_h_005fform_005f0.doInitBody();
      }
      do {
        if (_jspx_meth_h_005fpanelGrid_005f0(_jspx_th_h_005fform_005f0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_h_005fform_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_h_005fform_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_h_005fform_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005fform_005f0.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005fform_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005fform.reuse(_jspx_th_h_005fform_005f0);
    return false;
  }

  private boolean _jspx_meth_h_005fpanelGrid_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_h_005fform_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:panelGrid
    com.sun.faces.taglib.html_basic.PanelGridTag _jspx_th_h_005fpanelGrid_005f0 = new com.sun.faces.taglib.html_basic.PanelGridTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005fpanelGrid_005f0);
    _jspx_th_h_005fpanelGrid_005f0.setPageContext(_jspx_page_context);
    _jspx_th_h_005fpanelGrid_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_005fform_005f0);
    // /pages/instructor/courses.jsp(15,71) name = columnClasses type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_h_005fpanelGrid_005f0.setColumnClasses(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(15,71) 'menu'",_el_expressionfactory.createValueExpression("menu",java.lang.String.class)));
    // /pages/instructor/courses.jsp(15,71) name = style type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_h_005fpanelGrid_005f0.setStyle(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(15,71) 'width: 800px'",_el_expressionfactory.createValueExpression("width: 800px",java.lang.String.class)));
    // /pages/instructor/courses.jsp(15,71) name = columns type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = int deferredMethod = false methodSignature = null
    _jspx_th_h_005fpanelGrid_005f0.setColumns(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(15,71) '3'",_el_expressionfactory.createValueExpression("3",int.class)));
    _jspx_th_h_005fpanelGrid_005f0.setJspId("jsp_1042474162_2");
    int _jspx_eval_h_005fpanelGrid_005f0 = _jspx_th_h_005fpanelGrid_005f0.doStartTag();
    if (_jspx_eval_h_005fpanelGrid_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_h_005fpanelGrid_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_h_005fpanelGrid_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_h_005fpanelGrid_005f0.doInitBody();
      }
      do {
        if (_jspx_meth_htm_005fdiv_005f0(_jspx_th_h_005fpanelGrid_005f0, _jspx_page_context))
          return true;
        if (_jspx_meth_af_005fspacer_005f5(_jspx_th_h_005fpanelGrid_005f0, _jspx_page_context))
          return true;
        if (_jspx_meth_htm_005fdiv_005f1(_jspx_th_h_005fpanelGrid_005f0, _jspx_page_context))
          return true;
        if (_jspx_meth_htm_005fdiv_005f2(_jspx_th_h_005fpanelGrid_005f0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_h_005fpanelGrid_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_h_005fpanelGrid_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_h_005fpanelGrid_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005fpanelGrid_005f0.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005fpanelGrid_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005fpanelGrid_0026_005fstyle_005fcolumns_005fcolumnClasses.reuse(_jspx_th_h_005fpanelGrid_005f0);
    return false;
  }

  private boolean _jspx_meth_htm_005fdiv_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_h_005fpanelGrid_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  htm:div
    com.exadel.htmLib.tags.DivTag _jspx_th_htm_005fdiv_005f0 = new com.exadel.htmLib.tags.DivTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_htm_005fdiv_005f0);
    _jspx_th_htm_005fdiv_005f0.setPageContext(_jspx_page_context);
    _jspx_th_htm_005fdiv_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_005fpanelGrid_005f0);
    // /pages/instructor/courses.jsp(17,36) name = style type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_htm_005fdiv_005f0.setStyle("width: 170px;");
    _jspx_th_htm_005fdiv_005f0.setJspId("jsp_1042474162_3");
    int _jspx_eval_htm_005fdiv_005f0 = _jspx_th_htm_005fdiv_005f0.doStartTag();
    if (_jspx_eval_htm_005fdiv_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_htm_005fdiv_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_htm_005fdiv_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_htm_005fdiv_005f0.doInitBody();
      }
      do {
        if (_jspx_meth_af_005fspacer_005f0(_jspx_th_htm_005fdiv_005f0, _jspx_page_context))
          return true;
        if (_jspx_meth_h_005foutputText_005f0(_jspx_th_htm_005fdiv_005f0, _jspx_page_context))
          return true;
        if (_jspx_meth_af_005fspacer_005f1(_jspx_th_htm_005fdiv_005f0, _jspx_page_context))
          return true;
        if (_jspx_meth_h_005fdataTable_005f0(_jspx_th_htm_005fdiv_005f0, _jspx_page_context))
          return true;
        if (_jspx_meth_af_005fspacer_005f3(_jspx_th_htm_005fdiv_005f0, _jspx_page_context))
          return true;
        if (_jspx_meth_h_005foutputText_005f3(_jspx_th_htm_005fdiv_005f0, _jspx_page_context))
          return true;
        if (_jspx_meth_af_005fspacer_005f4(_jspx_th_htm_005fdiv_005f0, _jspx_page_context))
          return true;
        if (_jspx_meth_h_005fpanelGrid_005f1(_jspx_th_htm_005fdiv_005f0, _jspx_page_context))
          return true;
        if (_jspx_meth_h_005fpanelGrid_005f2(_jspx_th_htm_005fdiv_005f0, _jspx_page_context))
          return true;
        if (_jspx_meth_h_005fpanelGrid_005f3(_jspx_th_htm_005fdiv_005f0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_htm_005fdiv_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_htm_005fdiv_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_htm_005fdiv_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_htm_005fdiv_005f0.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_htm_005fdiv_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fhtm_005fdiv_0026_005fstyle.reuse(_jspx_th_htm_005fdiv_005f0);
    return false;
  }

  private boolean _jspx_meth_af_005fspacer_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  af:spacer
    org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag _jspx_th_af_005fspacer_005f0 = new org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f0);
    _jspx_th_af_005fspacer_005f0.setPageContext(_jspx_page_context);
    _jspx_th_af_005fspacer_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f0);
    // /pages/instructor/courses.jsp(19,31) name = height type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_af_005fspacer_005f0.setHeight(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(19,31) '25'",_el_expressionfactory.createValueExpression("25",java.lang.Object.class)));
    _jspx_th_af_005fspacer_005f0.setJspId("jsp_1042474162_4");
    int _jspx_eval_af_005fspacer_005f0 = _jspx_th_af_005fspacer_005f0.doStartTag();
    if (_jspx_th_af_005fspacer_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_af_005fspacer_005f0.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005faf_005fspacer_0026_005fheight_005fnobody.reuse(_jspx_th_af_005fspacer_005f0);
    return false;
  }

  private boolean _jspx_meth_h_005foutputText_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:outputText
    com.sun.faces.taglib.html_basic.OutputTextTag _jspx_th_h_005foutputText_005f0 = new com.sun.faces.taglib.html_basic.OutputTextTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f0);
    _jspx_th_h_005foutputText_005f0.setPageContext(_jspx_page_context);
    _jspx_th_h_005foutputText_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f0);
    // /pages/instructor/courses.jsp(22,56) name = rendered type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = boolean deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f0.setRendered(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(22,56) '#{!empty instructorCourses.courses}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"#{!empty instructorCourses.courses}",boolean.class)));
    // /pages/instructor/courses.jsp(22,56) name = styleClass type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f0.setStyleClass(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(22,56) 'menu_title'",_el_expressionfactory.createValueExpression("menu_title",java.lang.String.class)));
    // /pages/instructor/courses.jsp(22,56) name = value type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(22,56) 'Cursos'",_el_expressionfactory.createValueExpression("Cursos",java.lang.Object.class)));
    _jspx_th_h_005foutputText_005f0.setJspId("jsp_1042474162_5");
    int _jspx_eval_h_005foutputText_005f0 = _jspx_th_h_005foutputText_005f0.doStartTag();
    if (_jspx_th_h_005foutputText_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005foutputText_005f0.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fstyleClass_005frendered_005fnobody.reuse(_jspx_th_h_005foutputText_005f0);
    return false;
  }

  private boolean _jspx_meth_af_005fspacer_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  af:spacer
    org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag _jspx_th_af_005fspacer_005f1 = new org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f1);
    _jspx_th_af_005fspacer_005f1.setPageContext(_jspx_page_context);
    _jspx_th_af_005fspacer_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f0);
    // /pages/instructor/courses.jsp(25,56) name = rendered type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = boolean deferredMethod = false methodSignature = null
    _jspx_th_af_005fspacer_005f1.setRendered(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(25,56) '#{!empty instructorCourses.courses}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"#{!empty instructorCourses.courses}",boolean.class)));
    // /pages/instructor/courses.jsp(25,56) name = height type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_af_005fspacer_005f1.setHeight(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(25,56) '5'",_el_expressionfactory.createValueExpression("5",java.lang.Object.class)));
    _jspx_th_af_005fspacer_005f1.setJspId("jsp_1042474162_6");
    int _jspx_eval_af_005fspacer_005f1 = _jspx_th_af_005fspacer_005f1.doStartTag();
    if (_jspx_th_af_005fspacer_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_af_005fspacer_005f1.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005faf_005fspacer_0026_005frendered_005fheight_005fnobody.reuse(_jspx_th_af_005fspacer_005f1);
    return false;
  }

  private boolean _jspx_meth_h_005fdataTable_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:dataTable
    com.sun.faces.taglib.html_basic.DataTableTag _jspx_th_h_005fdataTable_005f0 = new com.sun.faces.taglib.html_basic.DataTableTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005fdataTable_005f0);
    _jspx_th_h_005fdataTable_005f0.setPageContext(_jspx_page_context);
    _jspx_th_h_005fdataTable_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f0);
    // /pages/instructor/courses.jsp(29,54) name = rendered type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = boolean deferredMethod = false methodSignature = null
    _jspx_th_h_005fdataTable_005f0.setRendered(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(29,54) '#{!empty instructorCourses.courses}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"#{!empty instructorCourses.courses}",boolean.class)));
    // /pages/instructor/courses.jsp(29,54) name = width type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_h_005fdataTable_005f0.setWidth(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(29,54) '100%'",_el_expressionfactory.createValueExpression("100%",java.lang.String.class)));
    // /pages/instructor/courses.jsp(29,54) name = binding type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = javax.faces.component.UIComponent deferredMethod = false methodSignature = null
    _jspx_th_h_005fdataTable_005f0.setBinding(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(29,54) '#{instructorCourses.coursesTable}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"#{instructorCourses.coursesTable}",javax.faces.component.UIComponent.class)));
    // /pages/instructor/courses.jsp(29,54) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_h_005fdataTable_005f0.setVar("course");
    // /pages/instructor/courses.jsp(29,54) name = value type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_h_005fdataTable_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(29,54) '#{instructorCourses.courses}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"#{instructorCourses.courses}",java.lang.Object.class)));
    _jspx_th_h_005fdataTable_005f0.setJspId("jsp_1042474162_7");
    int _jspx_eval_h_005fdataTable_005f0 = _jspx_th_h_005fdataTable_005f0.doStartTag();
    if (_jspx_eval_h_005fdataTable_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_h_005fdataTable_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_h_005fdataTable_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_h_005fdataTable_005f0.doInitBody();
      }
      do {
        if (_jspx_meth_h_005fcolumn_005f0(_jspx_th_h_005fdataTable_005f0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_h_005fdataTable_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_h_005fdataTable_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_h_005fdataTable_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005fdataTable_005f0.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005fdataTable_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005fdataTable_0026_005fwidth_005fvar_005fvalue_005frendered_005fbinding.reuse(_jspx_th_h_005fdataTable_005f0);
    return false;
  }

  private boolean _jspx_meth_h_005fcolumn_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_h_005fdataTable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:column
    com.sun.faces.taglib.html_basic.ColumnTag _jspx_th_h_005fcolumn_005f0 = new com.sun.faces.taglib.html_basic.ColumnTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005fcolumn_005f0);
    _jspx_th_h_005fcolumn_005f0.setPageContext(_jspx_page_context);
    _jspx_th_h_005fcolumn_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_005fdataTable_005f0);
    _jspx_th_h_005fcolumn_005f0.setJspId("jsp_1042474162_8");
    int _jspx_eval_h_005fcolumn_005f0 = _jspx_th_h_005fcolumn_005f0.doStartTag();
    if (_jspx_eval_h_005fcolumn_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_h_005fcolumn_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_h_005fcolumn_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_h_005fcolumn_005f0.doInitBody();
      }
      do {
        if (_jspx_meth_af_005fspacer_005f2(_jspx_th_h_005fcolumn_005f0, _jspx_page_context))
          return true;
        if (_jspx_meth_h_005fcommandLink_005f0(_jspx_th_h_005fcolumn_005f0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_h_005fcolumn_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_h_005fcolumn_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_h_005fcolumn_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005fcolumn_005f0.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005fcolumn_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005fcolumn.reuse(_jspx_th_h_005fcolumn_005f0);
    return false;
  }

  private boolean _jspx_meth_af_005fspacer_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_h_005fcolumn_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  af:spacer
    org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag _jspx_th_af_005fspacer_005f2 = new org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f2);
    _jspx_th_af_005fspacer_005f2.setPageContext(_jspx_page_context);
    _jspx_th_af_005fspacer_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_005fcolumn_005f0);
    // /pages/instructor/courses.jsp(31,33) name = height type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_af_005fspacer_005f2.setHeight(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(31,33) '10'",_el_expressionfactory.createValueExpression("10",java.lang.Object.class)));
    _jspx_th_af_005fspacer_005f2.setJspId("jsp_1042474162_9");
    int _jspx_eval_af_005fspacer_005f2 = _jspx_th_af_005fspacer_005f2.doStartTag();
    if (_jspx_th_af_005fspacer_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_af_005fspacer_005f2.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005faf_005fspacer_0026_005fheight_005fnobody.reuse(_jspx_th_af_005fspacer_005f2);
    return false;
  }

  private boolean _jspx_meth_h_005fcommandLink_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_h_005fcolumn_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:commandLink
    com.sun.faces.taglib.html_basic.CommandLinkTag _jspx_th_h_005fcommandLink_005f0 = new com.sun.faces.taglib.html_basic.CommandLinkTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005fcommandLink_005f0);
    _jspx_th_h_005fcommandLink_005f0.setPageContext(_jspx_page_context);
    _jspx_th_h_005fcommandLink_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_005fcolumn_005f0);
    // /pages/instructor/courses.jsp(33,27) name = styleClass type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_h_005fcommandLink_005f0.setStyleClass(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(33,27) 'link'",_el_expressionfactory.createValueExpression("link",java.lang.String.class)));
    // /pages/instructor/courses.jsp(33,27) name = action type = javax.el.MethodExpression reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = true methodSignature = java.lang.Object action()
    _jspx_th_h_005fcommandLink_005f0.setAction(new org.apache.jasper.el.JspMethodExpression("/pages/instructor/courses.jsp(33,27) '#{instructorCourses.selectCourse}'",_el_expressionfactory.createMethodExpression(_jspx_page_context.getELContext(),"#{instructorCourses.selectCourse}",java.lang.Object.class,new Class[] {})));
    _jspx_th_h_005fcommandLink_005f0.setJspId("jsp_1042474162_10");
    int _jspx_eval_h_005fcommandLink_005f0 = _jspx_th_h_005fcommandLink_005f0.doStartTag();
    if (_jspx_eval_h_005fcommandLink_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_h_005fcommandLink_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_h_005fcommandLink_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_h_005fcommandLink_005f0.doInitBody();
      }
      do {
        if (_jspx_meth_h_005foutputText_005f1(_jspx_th_h_005fcommandLink_005f0, _jspx_page_context))
          return true;
        if (_jspx_meth_h_005foutputText_005f2(_jspx_th_h_005fcommandLink_005f0, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_h_005fcommandLink_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_h_005fcommandLink_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_h_005fcommandLink_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005fcommandLink_005f0.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005fcommandLink_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005fcommandLink_0026_005fstyleClass_005faction.reuse(_jspx_th_h_005fcommandLink_005f0);
    return false;
  }

  private boolean _jspx_meth_h_005foutputText_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_h_005fcommandLink_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:outputText
    com.sun.faces.taglib.html_basic.OutputTextTag _jspx_th_h_005foutputText_005f1 = new com.sun.faces.taglib.html_basic.OutputTextTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f1);
    _jspx_th_h_005foutputText_005f1.setPageContext(_jspx_page_context);
    _jspx_th_h_005foutputText_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_005fcommandLink_005f0);
    // /pages/instructor/courses.jsp(35,73) name = rendered type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = boolean deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f1.setRendered(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(35,73) '#{course.name != instructorCourses.activedCourse}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"#{course.name != instructorCourses.activedCourse}",boolean.class)));
    // /pages/instructor/courses.jsp(35,73) name = styleClass type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f1.setStyleClass(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(35,73) 'link'",_el_expressionfactory.createValueExpression("link",java.lang.String.class)));
    // /pages/instructor/courses.jsp(35,73) name = value type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f1.setValue(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(35,73) '#{course.name}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"#{course.name}",java.lang.Object.class)));
    _jspx_th_h_005foutputText_005f1.setJspId("jsp_1042474162_11");
    int _jspx_eval_h_005foutputText_005f1 = _jspx_th_h_005foutputText_005f1.doStartTag();
    if (_jspx_th_h_005foutputText_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005foutputText_005f1.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fstyleClass_005frendered_005fnobody.reuse(_jspx_th_h_005foutputText_005f1);
    return false;
  }

  private boolean _jspx_meth_h_005foutputText_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_h_005fcommandLink_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:outputText
    com.sun.faces.taglib.html_basic.OutputTextTag _jspx_th_h_005foutputText_005f2 = new com.sun.faces.taglib.html_basic.OutputTextTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f2);
    _jspx_th_h_005foutputText_005f2.setPageContext(_jspx_page_context);
    _jspx_th_h_005foutputText_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_005fcommandLink_005f0);
    // /pages/instructor/courses.jsp(37,73) name = rendered type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = boolean deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f2.setRendered(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(37,73) '#{course.name == instructorCourses.activedCourse}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"#{course.name == instructorCourses.activedCourse}",boolean.class)));
    // /pages/instructor/courses.jsp(37,73) name = styleClass type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f2.setStyleClass(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(37,73) 'link_hover'",_el_expressionfactory.createValueExpression("link_hover",java.lang.String.class)));
    // /pages/instructor/courses.jsp(37,73) name = value type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f2.setValue(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(37,73) '#{course.name}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"#{course.name}",java.lang.Object.class)));
    _jspx_th_h_005foutputText_005f2.setJspId("jsp_1042474162_12");
    int _jspx_eval_h_005foutputText_005f2 = _jspx_th_h_005foutputText_005f2.doStartTag();
    if (_jspx_th_h_005foutputText_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005foutputText_005f2.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fstyleClass_005frendered_005fnobody.reuse(_jspx_th_h_005foutputText_005f2);
    return false;
  }

  private boolean _jspx_meth_af_005fspacer_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  af:spacer
    org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag _jspx_th_af_005fspacer_005f3 = new org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f3);
    _jspx_th_af_005fspacer_005f3.setPageContext(_jspx_page_context);
    _jspx_th_af_005fspacer_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f0);
    // /pages/instructor/courses.jsp(43,56) name = rendered type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = boolean deferredMethod = false methodSignature = null
    _jspx_th_af_005fspacer_005f3.setRendered(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(43,56) '#{!empty instructorCourses.courses}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"#{!empty instructorCourses.courses}",boolean.class)));
    // /pages/instructor/courses.jsp(43,56) name = height type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_af_005fspacer_005f3.setHeight(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(43,56) '40'",_el_expressionfactory.createValueExpression("40",java.lang.Object.class)));
    _jspx_th_af_005fspacer_005f3.setJspId("jsp_1042474162_13");
    int _jspx_eval_af_005fspacer_005f3 = _jspx_th_af_005fspacer_005f3.doStartTag();
    if (_jspx_th_af_005fspacer_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_af_005fspacer_005f3.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005faf_005fspacer_0026_005frendered_005fheight_005fnobody.reuse(_jspx_th_af_005fspacer_005f3);
    return false;
  }

  private boolean _jspx_meth_h_005foutputText_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:outputText
    com.sun.faces.taglib.html_basic.OutputTextTag _jspx_th_h_005foutputText_005f3 = new com.sun.faces.taglib.html_basic.OutputTextTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f3);
    _jspx_th_h_005foutputText_005f3.setPageContext(_jspx_page_context);
    _jspx_th_h_005foutputText_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f0);
    // /pages/instructor/courses.jsp(45,60) name = styleClass type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f3.setStyleClass(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(45,60) 'menu_title'",_el_expressionfactory.createValueExpression("menu_title",java.lang.String.class)));
    // /pages/instructor/courses.jsp(45,60) name = value type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f3.setValue(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(45,60) 'Ações'",_el_expressionfactory.createValueExpression("Ações",java.lang.Object.class)));
    _jspx_th_h_005foutputText_005f3.setJspId("jsp_1042474162_14");
    int _jspx_eval_h_005foutputText_005f3 = _jspx_th_h_005foutputText_005f3.doStartTag();
    if (_jspx_th_h_005foutputText_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005foutputText_005f3.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fstyleClass_005fnobody.reuse(_jspx_th_h_005foutputText_005f3);
    return false;
  }

  private boolean _jspx_meth_af_005fspacer_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  af:spacer
    org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag _jspx_th_af_005fspacer_005f4 = new org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f4);
    _jspx_th_af_005fspacer_005f4.setPageContext(_jspx_page_context);
    _jspx_th_af_005fspacer_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f0);
    // /pages/instructor/courses.jsp(47,31) name = height type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_af_005fspacer_005f4.setHeight(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(47,31) '10'",_el_expressionfactory.createValueExpression("10",java.lang.Object.class)));
    _jspx_th_af_005fspacer_005f4.setJspId("jsp_1042474162_15");
    int _jspx_eval_af_005fspacer_005f4 = _jspx_th_af_005fspacer_005f4.doStartTag();
    if (_jspx_th_af_005fspacer_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_af_005fspacer_005f4.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005faf_005fspacer_0026_005fheight_005fnobody.reuse(_jspx_th_af_005fspacer_005f4);
    return false;
  }

  private boolean _jspx_meth_h_005fpanelGrid_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:panelGrid
    com.sun.faces.taglib.html_basic.PanelGridTag _jspx_th_h_005fpanelGrid_005f1 = new com.sun.faces.taglib.html_basic.PanelGridTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005fpanelGrid_005f1);
    _jspx_th_h_005fpanelGrid_005f1.setPageContext(_jspx_page_context);
    _jspx_th_h_005fpanelGrid_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f0);
    // /pages/instructor/courses.jsp(49,31) name = columns type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = int deferredMethod = false methodSignature = null
    _jspx_th_h_005fpanelGrid_005f1.setColumns(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(49,31) '2'",_el_expressionfactory.createValueExpression("2",int.class)));
    _jspx_th_h_005fpanelGrid_005f1.setJspId("jsp_1042474162_16");
    int _jspx_eval_h_005fpanelGrid_005f1 = _jspx_th_h_005fpanelGrid_005f1.doStartTag();
    if (_jspx_eval_h_005fpanelGrid_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_h_005fpanelGrid_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_h_005fpanelGrid_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_h_005fpanelGrid_005f1.doInitBody();
      }
      do {
        if (_jspx_meth_af_005fimage_005f0(_jspx_th_h_005fpanelGrid_005f1, _jspx_page_context))
          return true;
        if (_jspx_meth_h_005fcommandLink_005f1(_jspx_th_h_005fpanelGrid_005f1, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_h_005fpanelGrid_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_h_005fpanelGrid_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_h_005fpanelGrid_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005fpanelGrid_005f1.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005fpanelGrid_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005fpanelGrid_0026_005fcolumns.reuse(_jspx_th_h_005fpanelGrid_005f1);
    return false;
  }

  private boolean _jspx_meth_af_005fimage_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_h_005fpanelGrid_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  af:image
    org.apache.myfaces.trinidadinternal.taglib.core.output.CoreImageTag _jspx_th_af_005fimage_005f0 = new org.apache.myfaces.trinidadinternal.taglib.core.output.CoreImageTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_af_005fimage_005f0);
    _jspx_th_af_005fimage_005f0.setPageContext(_jspx_page_context);
    _jspx_th_af_005fimage_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_005fpanelGrid_005f1);
    // /pages/instructor/courses.jsp(50,47) name = source type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_af_005fimage_005f0.setSource(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(50,47) '/images/create.png'",_el_expressionfactory.createValueExpression("/images/create.png",java.lang.Object.class)));
    _jspx_th_af_005fimage_005f0.setJspId("jsp_1042474162_17");
    int _jspx_eval_af_005fimage_005f0 = _jspx_th_af_005fimage_005f0.doStartTag();
    if (_jspx_th_af_005fimage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_af_005fimage_005f0.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_af_005fimage_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005faf_005fimage_0026_005fsource_005fnobody.reuse(_jspx_th_af_005fimage_005f0);
    return false;
  }

  private boolean _jspx_meth_h_005fcommandLink_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_h_005fpanelGrid_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:commandLink
    com.sun.faces.taglib.html_basic.CommandLinkTag _jspx_th_h_005fcommandLink_005f1 = new com.sun.faces.taglib.html_basic.CommandLinkTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005fcommandLink_005f1);
    _jspx_th_h_005fcommandLink_005f1.setPageContext(_jspx_page_context);
    _jspx_th_h_005fcommandLink_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_005fpanelGrid_005f1);
    // /pages/instructor/courses.jsp(52,26) name = styleClass type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_h_005fcommandLink_005f1.setStyleClass(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(52,26) 'link'",_el_expressionfactory.createValueExpression("link",java.lang.String.class)));
    // /pages/instructor/courses.jsp(52,26) name = action type = javax.el.MethodExpression reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = true methodSignature = java.lang.Object action()
    _jspx_th_h_005fcommandLink_005f1.setAction(new org.apache.jasper.el.JspMethodExpression("/pages/instructor/courses.jsp(52,26) '#{instructorCourses.create}'",_el_expressionfactory.createMethodExpression(_jspx_page_context.getELContext(),"#{instructorCourses.create}",java.lang.Object.class,new Class[] {})));
    _jspx_th_h_005fcommandLink_005f1.setJspId("jsp_1042474162_18");
    int _jspx_eval_h_005fcommandLink_005f1 = _jspx_th_h_005fcommandLink_005f1.doStartTag();
    if (_jspx_eval_h_005fcommandLink_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_h_005fcommandLink_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_h_005fcommandLink_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_h_005fcommandLink_005f1.doInitBody();
      }
      do {
        if (_jspx_meth_h_005foutputText_005f4(_jspx_th_h_005fcommandLink_005f1, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_h_005fcommandLink_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_h_005fcommandLink_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_h_005fcommandLink_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005fcommandLink_005f1.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005fcommandLink_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005fcommandLink_0026_005fstyleClass_005faction.reuse(_jspx_th_h_005fcommandLink_005f1);
    return false;
  }

  private boolean _jspx_meth_h_005foutputText_005f4(javax.servlet.jsp.tagext.JspTag _jspx_th_h_005fcommandLink_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:outputText
    com.sun.faces.taglib.html_basic.OutputTextTag _jspx_th_h_005foutputText_005f4 = new com.sun.faces.taglib.html_basic.OutputTextTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f4);
    _jspx_th_h_005foutputText_005f4.setPageContext(_jspx_page_context);
    _jspx_th_h_005foutputText_005f4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_005fcommandLink_005f1);
    // /pages/instructor/courses.jsp(53,75) name = styleClass type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f4.setStyleClass(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(53,75) 'topmenu_link'",_el_expressionfactory.createValueExpression("topmenu_link",java.lang.String.class)));
    // /pages/instructor/courses.jsp(53,75) name = value type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f4.setValue(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(53,75) 'Criar Novo Curso'",_el_expressionfactory.createValueExpression("Criar Novo Curso",java.lang.Object.class)));
    _jspx_th_h_005foutputText_005f4.setJspId("jsp_1042474162_19");
    int _jspx_eval_h_005foutputText_005f4 = _jspx_th_h_005foutputText_005f4.doStartTag();
    if (_jspx_th_h_005foutputText_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005foutputText_005f4.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fstyleClass_005fnobody.reuse(_jspx_th_h_005foutputText_005f4);
    return false;
  }

  private boolean _jspx_meth_h_005fpanelGrid_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:panelGrid
    com.sun.faces.taglib.html_basic.PanelGridTag _jspx_th_h_005fpanelGrid_005f2 = new com.sun.faces.taglib.html_basic.PanelGridTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005fpanelGrid_005f2);
    _jspx_th_h_005fpanelGrid_005f2.setPageContext(_jspx_page_context);
    _jspx_th_h_005fpanelGrid_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f0);
    // /pages/instructor/courses.jsp(58,54) name = rendered type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = boolean deferredMethod = false methodSignature = null
    _jspx_th_h_005fpanelGrid_005f2.setRendered(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(58,54) '#{instructorCourses.course != null}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"#{instructorCourses.course != null}",boolean.class)));
    // /pages/instructor/courses.jsp(58,54) name = columns type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = int deferredMethod = false methodSignature = null
    _jspx_th_h_005fpanelGrid_005f2.setColumns(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(58,54) '2'",_el_expressionfactory.createValueExpression("2",int.class)));
    _jspx_th_h_005fpanelGrid_005f2.setJspId("jsp_1042474162_20");
    int _jspx_eval_h_005fpanelGrid_005f2 = _jspx_th_h_005fpanelGrid_005f2.doStartTag();
    if (_jspx_eval_h_005fpanelGrid_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_h_005fpanelGrid_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_h_005fpanelGrid_005f2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_h_005fpanelGrid_005f2.doInitBody();
      }
      do {
        if (_jspx_meth_af_005fimage_005f1(_jspx_th_h_005fpanelGrid_005f2, _jspx_page_context))
          return true;
        if (_jspx_meth_h_005fcommandLink_005f2(_jspx_th_h_005fpanelGrid_005f2, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_h_005fpanelGrid_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_h_005fpanelGrid_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_h_005fpanelGrid_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005fpanelGrid_005f2.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005fpanelGrid_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005fpanelGrid_0026_005frendered_005fcolumns.reuse(_jspx_th_h_005fpanelGrid_005f2);
    return false;
  }

  private boolean _jspx_meth_af_005fimage_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_h_005fpanelGrid_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  af:image
    org.apache.myfaces.trinidadinternal.taglib.core.output.CoreImageTag _jspx_th_af_005fimage_005f1 = new org.apache.myfaces.trinidadinternal.taglib.core.output.CoreImageTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_af_005fimage_005f1);
    _jspx_th_af_005fimage_005f1.setPageContext(_jspx_page_context);
    _jspx_th_af_005fimage_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_005fpanelGrid_005f2);
    // /pages/instructor/courses.jsp(59,45) name = source type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_af_005fimage_005f1.setSource(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(59,45) '/images/edit.png'",_el_expressionfactory.createValueExpression("/images/edit.png",java.lang.Object.class)));
    _jspx_th_af_005fimage_005f1.setJspId("jsp_1042474162_21");
    int _jspx_eval_af_005fimage_005f1 = _jspx_th_af_005fimage_005f1.doStartTag();
    if (_jspx_th_af_005fimage_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_af_005fimage_005f1.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_af_005fimage_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005faf_005fimage_0026_005fsource_005fnobody.reuse(_jspx_th_af_005fimage_005f1);
    return false;
  }

  private boolean _jspx_meth_h_005fcommandLink_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_h_005fpanelGrid_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:commandLink
    com.sun.faces.taglib.html_basic.CommandLinkTag _jspx_th_h_005fcommandLink_005f2 = new com.sun.faces.taglib.html_basic.CommandLinkTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005fcommandLink_005f2);
    _jspx_th_h_005fcommandLink_005f2.setPageContext(_jspx_page_context);
    _jspx_th_h_005fcommandLink_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_005fpanelGrid_005f2);
    // /pages/instructor/courses.jsp(61,26) name = styleClass type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_h_005fcommandLink_005f2.setStyleClass(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(61,26) 'link'",_el_expressionfactory.createValueExpression("link",java.lang.String.class)));
    // /pages/instructor/courses.jsp(61,26) name = action type = javax.el.MethodExpression reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = true methodSignature = java.lang.Object action()
    _jspx_th_h_005fcommandLink_005f2.setAction(new org.apache.jasper.el.JspMethodExpression("/pages/instructor/courses.jsp(61,26) '#{instructorCourses.edit}'",_el_expressionfactory.createMethodExpression(_jspx_page_context.getELContext(),"#{instructorCourses.edit}",java.lang.Object.class,new Class[] {})));
    _jspx_th_h_005fcommandLink_005f2.setJspId("jsp_1042474162_22");
    int _jspx_eval_h_005fcommandLink_005f2 = _jspx_th_h_005fcommandLink_005f2.doStartTag();
    if (_jspx_eval_h_005fcommandLink_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_h_005fcommandLink_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_h_005fcommandLink_005f2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_h_005fcommandLink_005f2.doInitBody();
      }
      do {
        if (_jspx_meth_h_005foutputText_005f5(_jspx_th_h_005fcommandLink_005f2, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_h_005fcommandLink_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_h_005fcommandLink_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_h_005fcommandLink_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005fcommandLink_005f2.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005fcommandLink_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005fcommandLink_0026_005fstyleClass_005faction.reuse(_jspx_th_h_005fcommandLink_005f2);
    return false;
  }

  private boolean _jspx_meth_h_005foutputText_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_h_005fcommandLink_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:outputText
    com.sun.faces.taglib.html_basic.OutputTextTag _jspx_th_h_005foutputText_005f5 = new com.sun.faces.taglib.html_basic.OutputTextTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f5);
    _jspx_th_h_005foutputText_005f5.setPageContext(_jspx_page_context);
    _jspx_th_h_005foutputText_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_005fcommandLink_005f2);
    // /pages/instructor/courses.jsp(62,71) name = styleClass type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f5.setStyleClass(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(62,71) 'topmenu_link'",_el_expressionfactory.createValueExpression("topmenu_link",java.lang.String.class)));
    // /pages/instructor/courses.jsp(62,71) name = value type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f5.setValue(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(62,71) 'Editar Curso'",_el_expressionfactory.createValueExpression("Editar Curso",java.lang.Object.class)));
    _jspx_th_h_005foutputText_005f5.setJspId("jsp_1042474162_23");
    int _jspx_eval_h_005foutputText_005f5 = _jspx_th_h_005foutputText_005f5.doStartTag();
    if (_jspx_th_h_005foutputText_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005foutputText_005f5.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fstyleClass_005fnobody.reuse(_jspx_th_h_005foutputText_005f5);
    return false;
  }

  private boolean _jspx_meth_h_005fpanelGrid_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:panelGrid
    com.sun.faces.taglib.html_basic.PanelGridTag _jspx_th_h_005fpanelGrid_005f3 = new com.sun.faces.taglib.html_basic.PanelGridTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005fpanelGrid_005f3);
    _jspx_th_h_005fpanelGrid_005f3.setPageContext(_jspx_page_context);
    _jspx_th_h_005fpanelGrid_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f0);
    // /pages/instructor/courses.jsp(67,54) name = rendered type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = boolean deferredMethod = false methodSignature = null
    _jspx_th_h_005fpanelGrid_005f3.setRendered(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(67,54) '#{instructorCourses.course != null}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"#{instructorCourses.course != null}",boolean.class)));
    // /pages/instructor/courses.jsp(67,54) name = columns type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = int deferredMethod = false methodSignature = null
    _jspx_th_h_005fpanelGrid_005f3.setColumns(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(67,54) '2'",_el_expressionfactory.createValueExpression("2",int.class)));
    _jspx_th_h_005fpanelGrid_005f3.setJspId("jsp_1042474162_24");
    int _jspx_eval_h_005fpanelGrid_005f3 = _jspx_th_h_005fpanelGrid_005f3.doStartTag();
    if (_jspx_eval_h_005fpanelGrid_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_h_005fpanelGrid_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_h_005fpanelGrid_005f3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_h_005fpanelGrid_005f3.doInitBody();
      }
      do {
        if (_jspx_meth_af_005fimage_005f2(_jspx_th_h_005fpanelGrid_005f3, _jspx_page_context))
          return true;
        if (_jspx_meth_h_005fcommandLink_005f3(_jspx_th_h_005fpanelGrid_005f3, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_h_005fpanelGrid_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_h_005fpanelGrid_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_h_005fpanelGrid_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005fpanelGrid_005f3.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005fpanelGrid_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005fpanelGrid_0026_005frendered_005fcolumns.reuse(_jspx_th_h_005fpanelGrid_005f3);
    return false;
  }

  private boolean _jspx_meth_af_005fimage_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_h_005fpanelGrid_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  af:image
    org.apache.myfaces.trinidadinternal.taglib.core.output.CoreImageTag _jspx_th_af_005fimage_005f2 = new org.apache.myfaces.trinidadinternal.taglib.core.output.CoreImageTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_af_005fimage_005f2);
    _jspx_th_af_005fimage_005f2.setPageContext(_jspx_page_context);
    _jspx_th_af_005fimage_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_005fpanelGrid_005f3);
    // /pages/instructor/courses.jsp(68,47) name = source type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_af_005fimage_005f2.setSource(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(68,47) '/images/remove.png'",_el_expressionfactory.createValueExpression("/images/remove.png",java.lang.Object.class)));
    _jspx_th_af_005fimage_005f2.setJspId("jsp_1042474162_25");
    int _jspx_eval_af_005fimage_005f2 = _jspx_th_af_005fimage_005f2.doStartTag();
    if (_jspx_th_af_005fimage_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_af_005fimage_005f2.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_af_005fimage_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005faf_005fimage_0026_005fsource_005fnobody.reuse(_jspx_th_af_005fimage_005f2);
    return false;
  }

  private boolean _jspx_meth_h_005fcommandLink_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_h_005fpanelGrid_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:commandLink
    com.sun.faces.taglib.html_basic.CommandLinkTag _jspx_th_h_005fcommandLink_005f3 = new com.sun.faces.taglib.html_basic.CommandLinkTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005fcommandLink_005f3);
    _jspx_th_h_005fcommandLink_005f3.setPageContext(_jspx_page_context);
    _jspx_th_h_005fcommandLink_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_005fpanelGrid_005f3);
    // /pages/instructor/courses.jsp(70,26) name = styleClass type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_h_005fcommandLink_005f3.setStyleClass(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(70,26) 'link'",_el_expressionfactory.createValueExpression("link",java.lang.String.class)));
    // /pages/instructor/courses.jsp(70,26) name = action type = javax.el.MethodExpression reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = true methodSignature = java.lang.Object action()
    _jspx_th_h_005fcommandLink_005f3.setAction(new org.apache.jasper.el.JspMethodExpression("/pages/instructor/courses.jsp(70,26) '#{instructorCourses.remove}'",_el_expressionfactory.createMethodExpression(_jspx_page_context.getELContext(),"#{instructorCourses.remove}",java.lang.Object.class,new Class[] {})));
    _jspx_th_h_005fcommandLink_005f3.setJspId("jsp_1042474162_26");
    int _jspx_eval_h_005fcommandLink_005f3 = _jspx_th_h_005fcommandLink_005f3.doStartTag();
    if (_jspx_eval_h_005fcommandLink_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_h_005fcommandLink_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_h_005fcommandLink_005f3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_h_005fcommandLink_005f3.doInitBody();
      }
      do {
        if (_jspx_meth_h_005foutputText_005f6(_jspx_th_h_005fcommandLink_005f3, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_h_005fcommandLink_005f3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_h_005fcommandLink_005f3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_h_005fcommandLink_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005fcommandLink_005f3.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005fcommandLink_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005fcommandLink_0026_005fstyleClass_005faction.reuse(_jspx_th_h_005fcommandLink_005f3);
    return false;
  }

  private boolean _jspx_meth_h_005foutputText_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_h_005fcommandLink_005f3, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:outputText
    com.sun.faces.taglib.html_basic.OutputTextTag _jspx_th_h_005foutputText_005f6 = new com.sun.faces.taglib.html_basic.OutputTextTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f6);
    _jspx_th_h_005foutputText_005f6.setPageContext(_jspx_page_context);
    _jspx_th_h_005foutputText_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_005fcommandLink_005f3);
    // /pages/instructor/courses.jsp(71,72) name = styleClass type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f6.setStyleClass(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(71,72) 'topmenu_link'",_el_expressionfactory.createValueExpression("topmenu_link",java.lang.String.class)));
    // /pages/instructor/courses.jsp(71,72) name = value type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f6.setValue(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(71,72) 'Remover Curso'",_el_expressionfactory.createValueExpression("Remover Curso",java.lang.Object.class)));
    _jspx_th_h_005foutputText_005f6.setJspId("jsp_1042474162_27");
    int _jspx_eval_h_005foutputText_005f6 = _jspx_th_h_005foutputText_005f6.doStartTag();
    if (_jspx_th_h_005foutputText_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005foutputText_005f6.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fstyleClass_005fnobody.reuse(_jspx_th_h_005foutputText_005f6);
    return false;
  }

  private boolean _jspx_meth_af_005fspacer_005f5(javax.servlet.jsp.tagext.JspTag _jspx_th_h_005fpanelGrid_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  af:spacer
    org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag _jspx_th_af_005fspacer_005f5 = new org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f5);
    _jspx_th_af_005fspacer_005f5.setPageContext(_jspx_page_context);
    _jspx_th_af_005fspacer_005f5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_005fpanelGrid_005f0);
    // /pages/instructor/courses.jsp(77,29) name = width type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_af_005fspacer_005f5.setWidth(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(77,29) '60'",_el_expressionfactory.createValueExpression("60",java.lang.Object.class)));
    _jspx_th_af_005fspacer_005f5.setJspId("jsp_1042474162_28");
    int _jspx_eval_af_005fspacer_005f5 = _jspx_th_af_005fspacer_005f5.doStartTag();
    if (_jspx_th_af_005fspacer_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_af_005fspacer_005f5.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005faf_005fspacer_0026_005fwidth_005fnobody.reuse(_jspx_th_af_005fspacer_005f5);
    return false;
  }

  private boolean _jspx_meth_htm_005fdiv_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_h_005fpanelGrid_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  htm:div
    com.exadel.htmLib.tags.DivTag _jspx_th_htm_005fdiv_005f1 = new com.exadel.htmLib.tags.DivTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_htm_005fdiv_005f1);
    _jspx_th_htm_005fdiv_005f1.setPageContext(_jspx_page_context);
    _jspx_th_htm_005fdiv_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_005fpanelGrid_005f0);
    // /pages/instructor/courses.jsp(80,53) name = rendered type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_htm_005fdiv_005f1.setRendered("#{instructorCourses.course != null}");
    // /pages/instructor/courses.jsp(80,53) name = style type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_htm_005fdiv_005f1.setStyle("width: 570px;");
    _jspx_th_htm_005fdiv_005f1.setJspId("jsp_1042474162_29");
    int _jspx_eval_htm_005fdiv_005f1 = _jspx_th_htm_005fdiv_005f1.doStartTag();
    if (_jspx_eval_htm_005fdiv_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_htm_005fdiv_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_htm_005fdiv_005f1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_htm_005fdiv_005f1.doInitBody();
      }
      do {
        if (_jspx_meth_af_005fspacer_005f6(_jspx_th_htm_005fdiv_005f1, _jspx_page_context))
          return true;
        if (_jspx_meth_h_005foutputText_005f7(_jspx_th_htm_005fdiv_005f1, _jspx_page_context))
          return true;
        if (_jspx_meth_af_005fspacer_005f7(_jspx_th_htm_005fdiv_005f1, _jspx_page_context))
          return true;
        if (_jspx_meth_h_005foutputText_005f8(_jspx_th_htm_005fdiv_005f1, _jspx_page_context))
          return true;
        if (_jspx_meth_h_005foutputText_005f9(_jspx_th_htm_005fdiv_005f1, _jspx_page_context))
          return true;
        if (_jspx_meth_af_005fspacer_005f8(_jspx_th_htm_005fdiv_005f1, _jspx_page_context))
          return true;
        if (_jspx_meth_h_005foutputText_005f10(_jspx_th_htm_005fdiv_005f1, _jspx_page_context))
          return true;
        if (_jspx_meth_h_005foutputText_005f11(_jspx_th_htm_005fdiv_005f1, _jspx_page_context))
          return true;
        if (_jspx_meth_af_005fspacer_005f9(_jspx_th_htm_005fdiv_005f1, _jspx_page_context))
          return true;
        if (_jspx_meth_h_005foutputText_005f12(_jspx_th_htm_005fdiv_005f1, _jspx_page_context))
          return true;
        if (_jspx_meth_h_005foutputText_005f13(_jspx_th_htm_005fdiv_005f1, _jspx_page_context))
          return true;
        if (_jspx_meth_af_005fspacer_005f10(_jspx_th_htm_005fdiv_005f1, _jspx_page_context))
          return true;
        if (_jspx_meth_h_005foutputText_005f14(_jspx_th_htm_005fdiv_005f1, _jspx_page_context))
          return true;
        if (_jspx_meth_h_005foutputText_005f15(_jspx_th_htm_005fdiv_005f1, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_htm_005fdiv_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_htm_005fdiv_005f1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_htm_005fdiv_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_htm_005fdiv_005f1.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_htm_005fdiv_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fhtm_005fdiv_0026_005fstyle_005frendered.reuse(_jspx_th_htm_005fdiv_005f1);
    return false;
  }

  private boolean _jspx_meth_af_005fspacer_005f6(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  af:spacer
    org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag _jspx_th_af_005fspacer_005f6 = new org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f6);
    _jspx_th_af_005fspacer_005f6.setPageContext(_jspx_page_context);
    _jspx_th_af_005fspacer_005f6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f1);
    // /pages/instructor/courses.jsp(82,31) name = height type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_af_005fspacer_005f6.setHeight(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(82,31) '20'",_el_expressionfactory.createValueExpression("20",java.lang.Object.class)));
    _jspx_th_af_005fspacer_005f6.setJspId("jsp_1042474162_30");
    int _jspx_eval_af_005fspacer_005f6 = _jspx_th_af_005fspacer_005f6.doStartTag();
    if (_jspx_th_af_005fspacer_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_af_005fspacer_005f6.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005faf_005fspacer_0026_005fheight_005fnobody.reuse(_jspx_th_af_005fspacer_005f6);
    return false;
  }

  private boolean _jspx_meth_h_005foutputText_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:outputText
    com.sun.faces.taglib.html_basic.OutputTextTag _jspx_th_h_005foutputText_005f7 = new com.sun.faces.taglib.html_basic.OutputTextTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f7);
    _jspx_th_h_005foutputText_005f7.setPageContext(_jspx_page_context);
    _jspx_th_h_005foutputText_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f1);
    // /pages/instructor/courses.jsp(84,75) name = styleClass type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f7.setStyleClass(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(84,75) 'title'",_el_expressionfactory.createValueExpression("title",java.lang.String.class)));
    // /pages/instructor/courses.jsp(84,75) name = value type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f7.setValue(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(84,75) 'Informações sobre o Curso'",_el_expressionfactory.createValueExpression("Informações sobre o Curso",java.lang.Object.class)));
    _jspx_th_h_005foutputText_005f7.setJspId("jsp_1042474162_31");
    int _jspx_eval_h_005foutputText_005f7 = _jspx_th_h_005foutputText_005f7.doStartTag();
    if (_jspx_th_h_005foutputText_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005foutputText_005f7.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fstyleClass_005fnobody.reuse(_jspx_th_h_005foutputText_005f7);
    return false;
  }

  private boolean _jspx_meth_af_005fspacer_005f7(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  af:spacer
    org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag _jspx_th_af_005fspacer_005f7 = new org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f7);
    _jspx_th_af_005fspacer_005f7.setPageContext(_jspx_page_context);
    _jspx_th_af_005fspacer_005f7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f1);
    // /pages/instructor/courses.jsp(86,31) name = height type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_af_005fspacer_005f7.setHeight(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(86,31) '25'",_el_expressionfactory.createValueExpression("25",java.lang.Object.class)));
    _jspx_th_af_005fspacer_005f7.setJspId("jsp_1042474162_32");
    int _jspx_eval_af_005fspacer_005f7 = _jspx_th_af_005fspacer_005f7.doStartTag();
    if (_jspx_th_af_005fspacer_005f7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_af_005fspacer_005f7.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f7);
      return true;
    }
    _005fjspx_005ftagPool_005faf_005fspacer_0026_005fheight_005fnobody.reuse(_jspx_th_af_005fspacer_005f7);
    return false;
  }

  private boolean _jspx_meth_h_005foutputText_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:outputText
    com.sun.faces.taglib.html_basic.OutputTextTag _jspx_th_h_005foutputText_005f8 = new com.sun.faces.taglib.html_basic.OutputTextTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f8);
    _jspx_th_h_005foutputText_005f8.setPageContext(_jspx_page_context);
    _jspx_th_h_005foutputText_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f1);
    // /pages/instructor/courses.jsp(88,56) name = styleClass type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f8.setStyleClass(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(88,56) 'label'",_el_expressionfactory.createValueExpression("label",java.lang.String.class)));
    // /pages/instructor/courses.jsp(88,56) name = value type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f8.setValue(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(88,56) 'Nome: '",_el_expressionfactory.createValueExpression("Nome: ",java.lang.Object.class)));
    _jspx_th_h_005foutputText_005f8.setJspId("jsp_1042474162_33");
    int _jspx_eval_h_005foutputText_005f8 = _jspx_th_h_005foutputText_005f8.doStartTag();
    if (_jspx_th_h_005foutputText_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005foutputText_005f8.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fstyleClass_005fnobody.reuse(_jspx_th_h_005foutputText_005f8);
    return false;
  }

  private boolean _jspx_meth_h_005foutputText_005f9(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:outputText
    com.sun.faces.taglib.html_basic.OutputTextTag _jspx_th_h_005foutputText_005f9 = new com.sun.faces.taglib.html_basic.OutputTextTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f9);
    _jspx_th_h_005foutputText_005f9.setPageContext(_jspx_page_context);
    _jspx_th_h_005foutputText_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f1);
    // /pages/instructor/courses.jsp(89,63) name = value type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f9.setValue(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(89,63) '#{instructorCourses.course.name}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"#{instructorCourses.course.name}",java.lang.Object.class)));
    _jspx_th_h_005foutputText_005f9.setJspId("jsp_1042474162_34");
    int _jspx_eval_h_005foutputText_005f9 = _jspx_th_h_005foutputText_005f9.doStartTag();
    if (_jspx_th_h_005foutputText_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005foutputText_005f9.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fnobody.reuse(_jspx_th_h_005foutputText_005f9);
    return false;
  }

  private boolean _jspx_meth_af_005fspacer_005f8(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  af:spacer
    org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag _jspx_th_af_005fspacer_005f8 = new org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f8);
    _jspx_th_af_005fspacer_005f8.setPageContext(_jspx_page_context);
    _jspx_th_af_005fspacer_005f8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f1);
    // /pages/instructor/courses.jsp(91,31) name = height type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_af_005fspacer_005f8.setHeight(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(91,31) '10'",_el_expressionfactory.createValueExpression("10",java.lang.Object.class)));
    _jspx_th_af_005fspacer_005f8.setJspId("jsp_1042474162_35");
    int _jspx_eval_af_005fspacer_005f8 = _jspx_th_af_005fspacer_005f8.doStartTag();
    if (_jspx_th_af_005fspacer_005f8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_af_005fspacer_005f8.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f8);
      return true;
    }
    _005fjspx_005ftagPool_005faf_005fspacer_0026_005fheight_005fnobody.reuse(_jspx_th_af_005fspacer_005f8);
    return false;
  }

  private boolean _jspx_meth_h_005foutputText_005f10(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:outputText
    com.sun.faces.taglib.html_basic.OutputTextTag _jspx_th_h_005foutputText_005f10 = new com.sun.faces.taglib.html_basic.OutputTextTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f10);
    _jspx_th_h_005foutputText_005f10.setPageContext(_jspx_page_context);
    _jspx_th_h_005foutputText_005f10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f1);
    // /pages/instructor/courses.jsp(93,58) name = styleClass type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f10.setStyleClass(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(93,58) 'label'",_el_expressionfactory.createValueExpression("label",java.lang.String.class)));
    // /pages/instructor/courses.jsp(93,58) name = value type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f10.setValue(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(93,58) 'Início: '",_el_expressionfactory.createValueExpression("Início: ",java.lang.Object.class)));
    _jspx_th_h_005foutputText_005f10.setJspId("jsp_1042474162_36");
    int _jspx_eval_h_005foutputText_005f10 = _jspx_th_h_005foutputText_005f10.doStartTag();
    if (_jspx_th_h_005foutputText_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005foutputText_005f10.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fstyleClass_005fnobody.reuse(_jspx_th_h_005foutputText_005f10);
    return false;
  }

  private boolean _jspx_meth_h_005foutputText_005f11(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:outputText
    com.sun.faces.taglib.html_basic.OutputTextTag _jspx_th_h_005foutputText_005f11 = new com.sun.faces.taglib.html_basic.OutputTextTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f11);
    _jspx_th_h_005foutputText_005f11.setPageContext(_jspx_page_context);
    _jspx_th_h_005foutputText_005f11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f1);
    // /pages/instructor/courses.jsp(94,66) name = value type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f11.setValue(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(94,66) '#{instructorCourses.course.startDate}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"#{instructorCourses.course.startDate}",java.lang.Object.class)));
    _jspx_th_h_005foutputText_005f11.setJspId("jsp_1042474162_37");
    int _jspx_eval_h_005foutputText_005f11 = _jspx_th_h_005foutputText_005f11.doStartTag();
    if (_jspx_eval_h_005foutputText_005f11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_h_005foutputText_005f11 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_h_005foutputText_005f11.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_h_005foutputText_005f11.doInitBody();
      }
      do {
        if (_jspx_meth_f_005fconvertDateTime_005f0(_jspx_th_h_005foutputText_005f11, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_h_005foutputText_005f11.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_h_005foutputText_005f11 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_h_005foutputText_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005foutputText_005f11.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f11);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue.reuse(_jspx_th_h_005foutputText_005f11);
    return false;
  }

  private boolean _jspx_meth_f_005fconvertDateTime_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_h_005foutputText_005f11, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:convertDateTime
    com.sun.faces.taglib.jsf_core.ConvertDateTimeTag _jspx_th_f_005fconvertDateTime_005f0 = (com.sun.faces.taglib.jsf_core.ConvertDateTimeTag) _005fjspx_005ftagPool_005ff_005fconvertDateTime_0026_005fpattern_005fnobody.get(com.sun.faces.taglib.jsf_core.ConvertDateTimeTag.class);
    _jspx_th_f_005fconvertDateTime_005f0.setPageContext(_jspx_page_context);
    _jspx_th_f_005fconvertDateTime_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_005foutputText_005f11);
    // /pages/instructor/courses.jsp(95,49) name = pattern type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_f_005fconvertDateTime_005f0.setPattern(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(95,49) 'dd/MM/yyyy'",_el_expressionfactory.createValueExpression("dd/MM/yyyy",java.lang.String.class)));
    int _jspx_eval_f_005fconvertDateTime_005f0 = _jspx_th_f_005fconvertDateTime_005f0.doStartTag();
    if (_jspx_th_f_005fconvertDateTime_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ff_005fconvertDateTime_0026_005fpattern_005fnobody.reuse(_jspx_th_f_005fconvertDateTime_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ff_005fconvertDateTime_0026_005fpattern_005fnobody.reuse(_jspx_th_f_005fconvertDateTime_005f0);
    return false;
  }

  private boolean _jspx_meth_af_005fspacer_005f9(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  af:spacer
    org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag _jspx_th_af_005fspacer_005f9 = new org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f9);
    _jspx_th_af_005fspacer_005f9.setPageContext(_jspx_page_context);
    _jspx_th_af_005fspacer_005f9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f1);
    // /pages/instructor/courses.jsp(98,31) name = height type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_af_005fspacer_005f9.setHeight(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(98,31) '10'",_el_expressionfactory.createValueExpression("10",java.lang.Object.class)));
    _jspx_th_af_005fspacer_005f9.setJspId("jsp_1042474162_38");
    int _jspx_eval_af_005fspacer_005f9 = _jspx_th_af_005fspacer_005f9.doStartTag();
    if (_jspx_th_af_005fspacer_005f9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_af_005fspacer_005f9.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f9);
      return true;
    }
    _005fjspx_005ftagPool_005faf_005fspacer_0026_005fheight_005fnobody.reuse(_jspx_th_af_005fspacer_005f9);
    return false;
  }

  private boolean _jspx_meth_h_005foutputText_005f12(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:outputText
    com.sun.faces.taglib.html_basic.OutputTextTag _jspx_th_h_005foutputText_005f12 = new com.sun.faces.taglib.html_basic.OutputTextTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f12);
    _jspx_th_h_005foutputText_005f12.setPageContext(_jspx_page_context);
    _jspx_th_h_005foutputText_005f12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f1);
    // /pages/instructor/courses.jsp(100,59) name = styleClass type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f12.setStyleClass(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(100,59) 'label'",_el_expressionfactory.createValueExpression("label",java.lang.String.class)));
    // /pages/instructor/courses.jsp(100,59) name = value type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f12.setValue(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(100,59) 'Término: '",_el_expressionfactory.createValueExpression("Término: ",java.lang.Object.class)));
    _jspx_th_h_005foutputText_005f12.setJspId("jsp_1042474162_39");
    int _jspx_eval_h_005foutputText_005f12 = _jspx_th_h_005foutputText_005f12.doStartTag();
    if (_jspx_th_h_005foutputText_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005foutputText_005f12.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f12);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fstyleClass_005fnobody.reuse(_jspx_th_h_005foutputText_005f12);
    return false;
  }

  private boolean _jspx_meth_h_005foutputText_005f13(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:outputText
    com.sun.faces.taglib.html_basic.OutputTextTag _jspx_th_h_005foutputText_005f13 = new com.sun.faces.taglib.html_basic.OutputTextTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f13);
    _jspx_th_h_005foutputText_005f13.setPageContext(_jspx_page_context);
    _jspx_th_h_005foutputText_005f13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f1);
    // /pages/instructor/courses.jsp(101,64) name = value type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f13.setValue(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(101,64) '#{instructorCourses.course.endDate}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"#{instructorCourses.course.endDate}",java.lang.Object.class)));
    _jspx_th_h_005foutputText_005f13.setJspId("jsp_1042474162_40");
    int _jspx_eval_h_005foutputText_005f13 = _jspx_th_h_005foutputText_005f13.doStartTag();
    if (_jspx_eval_h_005foutputText_005f13 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_h_005foutputText_005f13 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_h_005foutputText_005f13.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_h_005foutputText_005f13.doInitBody();
      }
      do {
        if (_jspx_meth_f_005fconvertDateTime_005f1(_jspx_th_h_005foutputText_005f13, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_h_005foutputText_005f13.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_h_005foutputText_005f13 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_h_005foutputText_005f13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005foutputText_005f13.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f13);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue.reuse(_jspx_th_h_005foutputText_005f13);
    return false;
  }

  private boolean _jspx_meth_f_005fconvertDateTime_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_h_005foutputText_005f13, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:convertDateTime
    com.sun.faces.taglib.jsf_core.ConvertDateTimeTag _jspx_th_f_005fconvertDateTime_005f1 = (com.sun.faces.taglib.jsf_core.ConvertDateTimeTag) _005fjspx_005ftagPool_005ff_005fconvertDateTime_0026_005fpattern_005fnobody.get(com.sun.faces.taglib.jsf_core.ConvertDateTimeTag.class);
    _jspx_th_f_005fconvertDateTime_005f1.setPageContext(_jspx_page_context);
    _jspx_th_f_005fconvertDateTime_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_005foutputText_005f13);
    // /pages/instructor/courses.jsp(102,49) name = pattern type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_f_005fconvertDateTime_005f1.setPattern(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(102,49) 'dd/MM/yyyy'",_el_expressionfactory.createValueExpression("dd/MM/yyyy",java.lang.String.class)));
    int _jspx_eval_f_005fconvertDateTime_005f1 = _jspx_th_f_005fconvertDateTime_005f1.doStartTag();
    if (_jspx_th_f_005fconvertDateTime_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ff_005fconvertDateTime_0026_005fpattern_005fnobody.reuse(_jspx_th_f_005fconvertDateTime_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005ff_005fconvertDateTime_0026_005fpattern_005fnobody.reuse(_jspx_th_f_005fconvertDateTime_005f1);
    return false;
  }

  private boolean _jspx_meth_af_005fspacer_005f10(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  af:spacer
    org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag _jspx_th_af_005fspacer_005f10 = new org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f10);
    _jspx_th_af_005fspacer_005f10.setPageContext(_jspx_page_context);
    _jspx_th_af_005fspacer_005f10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f1);
    // /pages/instructor/courses.jsp(105,31) name = height type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_af_005fspacer_005f10.setHeight(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(105,31) '10'",_el_expressionfactory.createValueExpression("10",java.lang.Object.class)));
    _jspx_th_af_005fspacer_005f10.setJspId("jsp_1042474162_41");
    int _jspx_eval_af_005fspacer_005f10 = _jspx_th_af_005fspacer_005f10.doStartTag();
    if (_jspx_th_af_005fspacer_005f10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_af_005fspacer_005f10.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f10);
      return true;
    }
    _005fjspx_005ftagPool_005faf_005fspacer_0026_005fheight_005fnobody.reuse(_jspx_th_af_005fspacer_005f10);
    return false;
  }

  private boolean _jspx_meth_h_005foutputText_005f14(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:outputText
    com.sun.faces.taglib.html_basic.OutputTextTag _jspx_th_h_005foutputText_005f14 = new com.sun.faces.taglib.html_basic.OutputTextTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f14);
    _jspx_th_h_005foutputText_005f14.setPageContext(_jspx_page_context);
    _jspx_th_h_005foutputText_005f14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f1);
    // /pages/instructor/courses.jsp(107,61) name = styleClass type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f14.setStyleClass(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(107,61) 'label'",_el_expressionfactory.createValueExpression("label",java.lang.String.class)));
    // /pages/instructor/courses.jsp(107,61) name = value type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f14.setValue(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(107,61) 'Professor: '",_el_expressionfactory.createValueExpression("Professor: ",java.lang.Object.class)));
    _jspx_th_h_005foutputText_005f14.setJspId("jsp_1042474162_42");
    int _jspx_eval_h_005foutputText_005f14 = _jspx_th_h_005foutputText_005f14.doStartTag();
    if (_jspx_th_h_005foutputText_005f14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005foutputText_005f14.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f14);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fstyleClass_005fnobody.reuse(_jspx_th_h_005foutputText_005f14);
    return false;
  }

  private boolean _jspx_meth_h_005foutputText_005f15(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:outputText
    com.sun.faces.taglib.html_basic.OutputTextTag _jspx_th_h_005foutputText_005f15 = new com.sun.faces.taglib.html_basic.OutputTextTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f15);
    _jspx_th_h_005foutputText_005f15.setPageContext(_jspx_page_context);
    _jspx_th_h_005foutputText_005f15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f1);
    // /pages/instructor/courses.jsp(108,74) name = value type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f15.setValue(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(108,74) '#{instructorCourses.course.instructor.name}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"#{instructorCourses.course.instructor.name}",java.lang.Object.class)));
    _jspx_th_h_005foutputText_005f15.setJspId("jsp_1042474162_43");
    int _jspx_eval_h_005foutputText_005f15 = _jspx_th_h_005foutputText_005f15.doStartTag();
    if (_jspx_th_h_005foutputText_005f15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005foutputText_005f15.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f15);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fnobody.reuse(_jspx_th_h_005foutputText_005f15);
    return false;
  }

  private boolean _jspx_meth_htm_005fdiv_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_h_005fpanelGrid_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  htm:div
    com.exadel.htmLib.tags.DivTag _jspx_th_htm_005fdiv_005f2 = new com.exadel.htmLib.tags.DivTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_htm_005fdiv_005f2);
    _jspx_th_htm_005fdiv_005f2.setPageContext(_jspx_page_context);
    _jspx_th_htm_005fdiv_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_h_005fpanelGrid_005f0);
    // /pages/instructor/courses.jsp(113,53) name = rendered type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_htm_005fdiv_005f2.setRendered("#{instructorCourses.course == null}");
    // /pages/instructor/courses.jsp(113,53) name = style type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_htm_005fdiv_005f2.setStyle("width: 570px;");
    _jspx_th_htm_005fdiv_005f2.setJspId("jsp_1042474162_44");
    int _jspx_eval_htm_005fdiv_005f2 = _jspx_th_htm_005fdiv_005f2.doStartTag();
    if (_jspx_eval_htm_005fdiv_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_htm_005fdiv_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_htm_005fdiv_005f2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_htm_005fdiv_005f2.doInitBody();
      }
      do {
        if (_jspx_meth_af_005fspacer_005f11(_jspx_th_htm_005fdiv_005f2, _jspx_page_context))
          return true;
        if (_jspx_meth_h_005foutputText_005f16(_jspx_th_htm_005fdiv_005f2, _jspx_page_context))
          return true;
        if (_jspx_meth_af_005fspacer_005f12(_jspx_th_htm_005fdiv_005f2, _jspx_page_context))
          return true;
        if (_jspx_meth_h_005foutputText_005f17(_jspx_th_htm_005fdiv_005f2, _jspx_page_context))
          return true;
        int evalDoAfterBody = _jspx_th_htm_005fdiv_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_htm_005fdiv_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_htm_005fdiv_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_htm_005fdiv_005f2.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_htm_005fdiv_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fhtm_005fdiv_0026_005fstyle_005frendered.reuse(_jspx_th_htm_005fdiv_005f2);
    return false;
  }

  private boolean _jspx_meth_af_005fspacer_005f11(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  af:spacer
    org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag _jspx_th_af_005fspacer_005f11 = new org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f11);
    _jspx_th_af_005fspacer_005f11.setPageContext(_jspx_page_context);
    _jspx_th_af_005fspacer_005f11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f2);
    // /pages/instructor/courses.jsp(115,31) name = height type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_af_005fspacer_005f11.setHeight(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(115,31) '20'",_el_expressionfactory.createValueExpression("20",java.lang.Object.class)));
    _jspx_th_af_005fspacer_005f11.setJspId("jsp_1042474162_45");
    int _jspx_eval_af_005fspacer_005f11 = _jspx_th_af_005fspacer_005f11.doStartTag();
    if (_jspx_th_af_005fspacer_005f11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_af_005fspacer_005f11.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f11);
      return true;
    }
    _005fjspx_005ftagPool_005faf_005fspacer_0026_005fheight_005fnobody.reuse(_jspx_th_af_005fspacer_005f11);
    return false;
  }

  private boolean _jspx_meth_h_005foutputText_005f16(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:outputText
    com.sun.faces.taglib.html_basic.OutputTextTag _jspx_th_h_005foutputText_005f16 = new com.sun.faces.taglib.html_basic.OutputTextTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f16);
    _jspx_th_h_005foutputText_005f16.setPageContext(_jspx_page_context);
    _jspx_th_h_005foutputText_005f16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f2);
    // /pages/instructor/courses.jsp(117,75) name = styleClass type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f16.setStyleClass(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(117,75) 'title'",_el_expressionfactory.createValueExpression("title",java.lang.String.class)));
    // /pages/instructor/courses.jsp(117,75) name = value type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f16.setValue(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(117,75) 'Informações sobre o Curso'",_el_expressionfactory.createValueExpression("Informações sobre o Curso",java.lang.Object.class)));
    _jspx_th_h_005foutputText_005f16.setJspId("jsp_1042474162_46");
    int _jspx_eval_h_005foutputText_005f16 = _jspx_th_h_005foutputText_005f16.doStartTag();
    if (_jspx_th_h_005foutputText_005f16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005foutputText_005f16.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f16);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fstyleClass_005fnobody.reuse(_jspx_th_h_005foutputText_005f16);
    return false;
  }

  private boolean _jspx_meth_af_005fspacer_005f12(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  af:spacer
    org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag _jspx_th_af_005fspacer_005f12 = new org.apache.myfaces.trinidadinternal.taglib.core.output.CoreSpacerTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f12);
    _jspx_th_af_005fspacer_005f12.setPageContext(_jspx_page_context);
    _jspx_th_af_005fspacer_005f12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f2);
    // /pages/instructor/courses.jsp(119,31) name = height type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_af_005fspacer_005f12.setHeight(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(119,31) '20'",_el_expressionfactory.createValueExpression("20",java.lang.Object.class)));
    _jspx_th_af_005fspacer_005f12.setJspId("jsp_1042474162_47");
    int _jspx_eval_af_005fspacer_005f12 = _jspx_th_af_005fspacer_005f12.doStartTag();
    if (_jspx_th_af_005fspacer_005f12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_af_005fspacer_005f12.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_af_005fspacer_005f12);
      return true;
    }
    _005fjspx_005ftagPool_005faf_005fspacer_0026_005fheight_005fnobody.reuse(_jspx_th_af_005fspacer_005f12);
    return false;
  }

  private boolean _jspx_meth_h_005foutputText_005f17(javax.servlet.jsp.tagext.JspTag _jspx_th_htm_005fdiv_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  h:outputText
    com.sun.faces.taglib.html_basic.OutputTextTag _jspx_th_h_005foutputText_005f17 = new com.sun.faces.taglib.html_basic.OutputTextTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f17);
    _jspx_th_h_005foutputText_005f17.setPageContext(_jspx_page_context);
    _jspx_th_h_005foutputText_005f17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_htm_005fdiv_005f2);
    // /pages/instructor/courses.jsp(121,56) name = value type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_h_005foutputText_005f17.setValue(new org.apache.jasper.el.JspValueExpression("/pages/instructor/courses.jsp(121,56) 'Nenhum curso selecionado.'",_el_expressionfactory.createValueExpression("Nenhum curso selecionado.",java.lang.Object.class)));
    _jspx_th_h_005foutputText_005f17.setJspId("jsp_1042474162_48");
    int _jspx_eval_h_005foutputText_005f17 = _jspx_th_h_005foutputText_005f17.doStartTag();
    if (_jspx_th_h_005foutputText_005f17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_th_h_005foutputText_005f17.release();
      org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_h_005foutputText_005f17);
      return true;
    }
    _005fjspx_005ftagPool_005fh_005foutputText_0026_005fvalue_005fnobody.reuse(_jspx_th_h_005foutputText_005f17);
    return false;
  }
}
