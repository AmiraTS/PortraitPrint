// pages/stylization/stylization.js
Page({
  data: {
    upload_pic:'',
    currentIndex: 0,
    currentIndex1: 0,
    currentIndex2: 0,
    imgList1: [{ 
      img: "/static/images/style1.png",
      style:"风格1"
    },
    {
      img: "/static/images/style2.png",
      style:"风格2"
    },
    {
      img: "/static/images/style3.png",
      style:"风格3"
    }
    ],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var pic=wx.getStorageSync('key')
    this.setData({
      upload_pic:pic
    })
    
  },

  design:function(){
    // wx.setStorageSync('key1', this.upload_pic)
    this.apiGo();
    // console.log(wx.getStorageSync('key'))
    wx.navigateTo({
      // url: '../designResult/designResult',
      url: '../stylization/stylization',
    })
  },

  apiGo:function(res){

    wx.request({
      url: 'https://aip.baidubce.com/rest/2.0/image-process/v1/style_trans',
      data: {               //请求时传送我们的账号信息进行认证
        grant_type: 'client_credentials',
        client_id: 'oLySR6UW3L5jK94WrkNdMF2z',//APIKey
        client_secret: 'l2rWPxlwdvrW0pRTfahuKFGyYC3l7PbG',//SecretKey
      },
      success(res) {
        // console.log(res.data.access_token)
        let token = res.data.access_token

        wx.request({
          method: 'POST', 
          url: 'https://i.328888.xyz/2023/04/17/ieYFdb.th.jpeg',
          header: {
            "Content-type": "application/x-www-form-urlencoded",//决定用哪种post请求，是固定的
          },
          data: {           //请求时需要上传的数据
            url: wx.getStorageSync('key'),	
            option: 'pencil',
          },
          success: function (res) {
            console.log(res.data)
            
          }

        })

      }

    })
  },


  changeSwiper1: function (e) {
    this.setData({
      currentIndex1: e.detail.current
    })
  },

})