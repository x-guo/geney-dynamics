package org.mybatis.ext.template;

import java.util.List;

import org.mybatis.ext.data.ResultMap;

public class ViewListTemplate {

    private String viewListString;

    public ViewListTemplate(List<ResultMap> resultMaps){
        setViewListString(buildViewList(resultMaps));
    }

    private String buildViewList(List<ResultMap> resultMaps) {
        if (resultMaps == null || resultMaps.size() == 0) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append("<div class=\"filter\">\n");
        buffer.append("  <form action=\"\">\n");
        buffer.append("    <table>\n");
        buffer.append("      <tr>\n");
        buffer.append("        <td><input type=\"text\" name=\"name\" value=\"$!{query.name}\" placeholder=\"名称\"></td>\n");
        buffer.append("        <td><input type=\"submit\" value=\"查询\"></td>\n");
        buffer.append("      </tr>\n");
        buffer.append("    </table>\n");
        buffer.append("  </form>\n");
        buffer.append("</div>\n");

        buffer.append("<div class=\"content\">\n");
        buffer.append("  #if($result)\n");
        buffer.append("  <table>\n");
        buffer.append("    <thead>\n");
        buffer.append("      <tr>\n");
        for (ResultMap obj : resultMaps) {
            buffer.append("        <th>" + obj.getProp() + "</th>\n");
        }

        buffer.append("      </tr>\n");
        buffer.append("    </thead>\n");
        buffer.append("    <tbody>\n");
        buffer.append("    #foreach($!model in $!result.result)\n");
        buffer.append("      <tr>\n");
        for (ResultMap obj : resultMaps) {
            buffer.append("        <td>" + "model." + obj.getProp() + "</td>\n");
        }
        buffer.append("      </tr>\n");
        buffer.append("    #end\n");
        buffer.append("    </tbody>\n");
        buffer.append("  </table>\n");
        buffer.append("  #end\n");
        buffer.append("</div>\n");

        return buffer.toString();
    }

    public String getViewListString() {
        return viewListString;
    }

    public void setViewListString(String viewListString) {
        this.viewListString = viewListString;
    }
}
