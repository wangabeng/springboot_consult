<template>
  <div class="m-editor">
    <!-- 选项 -->
    <div class="container-fluid">
      <div class="col-md-12">
        <form>
          <div class="form-group row">
            <label for="inputEmail3" class="col-sm-2 col-form-label">作者</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="inputEmail3" placeholder="润捷">
            </div>
          </div>


          <div class="form-group row">
            <label for="inputPassword3" class="col-sm-2 col-form-label">标题</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="inputPassword3" placeholder="请输入标题">
            </div>
          </div>

          <!-- 类型选择 -->
          <fieldset class="form-group">
            <div class="row">
              <legend class="col-form-label col-sm-2 pt-0">文章所属分类</legend>
              <div class="col-sm-10">
                <div class="form-check mb-3">
                  <input class="form-check-input" type="radio" name="gridRadios" id="type1" value="option1" checked>
                  <label class="form-check-label" for="type1">
                    新闻中心
                  </label>
                </div>
                <!-- <div class="form-check mb-3">
                  <input class="form-check-input" type="radio" name="gridRadios" id="type2" value="option2">
                  <label class="form-check-label" for="type2">
                    Second radio
                  </label>
                </div> -->
                <!-- <div class="form-check disabled mb-3">
                  <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="option3" disabled>
                  <label class="form-check-label" for="gridRadios3">
                    新闻中心
                  </label>
                </div> -->
              </div>
            </div>
          </fieldset>

          <!-- 文件上传 -->
          <div class="form-group">
            <label for="exampleInputFile" class='row'>
              <span class='col-sm-2'>主题图片</span>
              <p type="button" class="btn btn-primary col-sm-2 ml-3">上传主图</p>
            </label>
            <input type="file" class="form-control-file" style='display: none' id="exampleInputFile" @change="uploadFile($event)"/>
          </div>
          
          <!-- 文件上传回显 -->
          <ul class="show-pic d-flex align-items-center justify-content-start" v-if='uploadSum'>
            <li class="each-image list-unstyled mr-5" style="background-image: url('https://ss1.bdstatic.com/5eN1bjq8AAUYm2zgoY3K/r/www/cache/static/protocol/https/home/img/qrcode/zbios_x2_5869f49.png');"
              v-bind:style="{ backgroundImage: 'url(' + uploadSum + ')' }"
              ><i class="fa fa-times" aria-hidden="true" @click='deleteImg'></i></li>
          </ul>

        </form>
      </div>
      
      <div class="col-md-12">
        <h6 class='mb-3 mt-4'>编辑内容：</h6>
        <div ref="editor" style="text-align:left;background-color: #fff;"></div>
        <p><button class="btn btn-primary mt-4" id="btnGenCode" role="button" @click='editorSubmit'>保存 »</button></p>
      </div>     
    </div>
    


  </div>
</template>

<script>
import E from 'wangeditor'
// import axios from 'axios'
import axios from 'src/api/axios';
import {BASEURL} from "src/api/config.js"

export default {
  name: 'Editor',
  data () {
    return {
      'uploadSum': '',
      'editorHtml': '',
      'uploadfile': '',
    };
  },
  props: {
    msg: String
  },
  methods: {
    // 移除上传的图片
    deleteImg () {
      this.uploadSum = '';
    },
    // 普通上传文件
    uploadFile (event) {
      var _this = this;

      this.file = event.target.files[0];

      let param = new FormData();
      // param.append("name", "wiiiiiinney");
      //通过append向form对象添加数据
      param.append("file", this.file);

      let config = {
        //添加请求头
        headers: { "Content-Type": "multipart/form-data" },
        //添加上传进度监听事件
        /*onUploadProgress: e => {
          var completeProgress = ((e.loaded / e.total * 100) | 0) + "%";
          this.progress = completeProgress;
        }*/
      };

      axios.post(BASEURL + '/article/upload', param, config)
        .then(function (response) {
           // console.log(response);
           _this.uploadSum = response.data;
        })
        .catch(function (error) {
          //console.log(error);
        });

    },
    // 最终提交
    editorSubmit () {
      console.log(this.editorHtml);
      var _this = this;
      // 可选地，上面的请求可以这样做
      axios.post(BASEURL + '/article/editorsubmit', {
          params: {
            author: "张三",
            type: "新闻中心",
            mainPic: _this.uploadSum, 
            content: _this.editorHtml
          }
        })
        .then(function (response) {
          console.log(response);
        })
        .catch(function (error) {
          console.log(error);
        });
    }
  },
  mounted () {
    var _this = this;
    var editor = new E(this.$refs.editor);
    editor.customConfig = {
      onchange:function(html){
        _this.editorHtml = html;
        // 获取html内容
        // console.log(html);
      },
      uploadImgServer: BASEURL + '/article/editorupload', // 上传图片到服务器
      uploadFileName : 'file', //后端使用这个字段获取图片信息
      uploadImgMaxLength : 1 , // 限制一次最多上传 1 张图片
    };
    editor.create();
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
@import "common/sass/variable.scss";
.m-editor {
  margin: 0;
  padding: 3rem;
}

// 文件上传回显
.show-pic {

  .each-image {
    margin-top: 1rem;
    width: 5rem;
    height: 5rem;
    background-repeat: no-repeat;
    background-size: cover;
    background-position: center center;
    
    position: relative;
    i {
      position: absolute;
      top: -.5rem;
      right: -1rem;
      color: var(--orange);
    }

  }
}
</style>