package actions.goldenbook_supplychain.pojos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "meta_tbnm",
        "meta_chgtyp",
        "meta_chgtm",
        "client_id",
        "supnum",
        "adr_id",
        "trk_cnsg_cod",
        "trust_flg",
        "rcvsts",
        "lot_fmt_id",
        "ser_num_typ_id",
        "asset_typ",
        "bar_code_tmpl_id",
        "load_attr1_cfg",
        "load_attr2_cfg",
        "load_attr3_cfg",
        "load_attr4_cfg",
        "load_attr5_cfg",
        "ins_dt",
        "last_upd_dt",
        "cnsg_cod",
        "cnsg_period",
        "ins_user_id",
        "last_upd_user_id",
        "host_ext_id",
        "adrnam",
        "adrtyp",
        "adrln1",
        "adrln2",
        "adrln3",
        "adrcty",
        "adrstc",
        "adrpsz",
        "ctry_name",
        "processing_date"
})
public class SupmstRecord {
    public String meta_tbnm;
    public String meta_chgtyp;
    public String meta_chgtm;
    public String client_id;
    public String supnum;
    public String adr_id;
    public String trk_cnsg_cod;
    public Integer trust_flg;
    public String rcvsts;
    public String lot_fmt_id;
    public String ser_num_typ_id;
    public String asset_typ;
    public String bar_code_tmpl_id;
    public String load_attr1_cfg;
    public String load_attr2_cfg;
    public String load_attr3_cfg;
    public String load_attr4_cfg;
    public String load_attr5_cfg;
    public String ins_dt;
    public String last_upd_dt;
    public String cnsg_cod;
    public String cnsg_period;
    public String ins_user_id;
    public String last_upd_user_id;
    public String host_ext_id;
    public String adrnam;
    public String adrtyp;
    public String adrln1;
    public String adrln2;
    public String adrln3;
    public String adrcty;
    public String adrstc;
    public String adrpsz;
    public String ctry_name;
    public String processing_date;
}
